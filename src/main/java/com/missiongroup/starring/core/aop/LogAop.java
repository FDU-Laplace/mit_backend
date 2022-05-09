package com.missiongroup.starring.core.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;
import com.missiongroup.starring.core.log.LogManager;
import com.missiongroup.starring.core.log.factory.LogTaskFactory;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.shiro.ShiroUser;
import com.missiongroup.starring.core.support.HttpKit;
import com.missiongroup.starring.core.util.Contrast;
import com.missiongroup.starring.core.util.ToolUtil;

/**
 * 日志记录
 *
 * @author mission
 * @date 2016年12月6日 下午8:48:30
 */
@Aspect
@Component
public class LogAop {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Pointcut(value = "@annotation(com.missiongroup.starring.common.annotion.BussinessLog)")
    public void cutService() {
    }

    @Around("cutService()")
    public Object recordSysLog(ProceedingJoinPoint point) throws Throwable {

        //先执行业务
        Object result = point.proceed();

        try {
            handle(point);
        } catch (Exception e) {
            log.error("日志记录出错!", e);
        }

        return result;
    }

    private void handle(ProceedingJoinPoint point) throws Exception {

        //获取拦截的方法名
        Signature sig = point.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = point.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        String methodName = currentMethod.getName();

        //如果当前用户未登录，不做日志
        ShiroUser user = ShiroKit.getUser();
        if (null == user) {
            return;
        }

        //获取拦截方法的参数
        String className = point.getTarget().getClass().getName();
        Object[] params = point.getArgs();

        //获取操作名称
        BussinessLog annotation = currentMethod.getAnnotation(BussinessLog.class);
        String bussinessName = annotation.value();
        String key = annotation.key();
        Class<?> dictClass = annotation.dict();

        Map<Object, Object> parameters = HttpKit.getRequestParameters();
        Map<Object, Object> requestMap = new HashMap<Object, Object>();
        
        String msg = bussinessName;
        if(ToolUtil.isNotEmpty(key)) {
        	 String[] keyStr = key.split(",");
             
             int i = 0; // 计数是第几个参数
             for (Object param : params) {
             	if(param instanceof String || param.getClass().isPrimitive()){
             		if(i <= keyStr.length -1) {
             			requestMap.put(keyStr[i], param);
             		}
             	}else if (!(param instanceof BindingResult)) {
             		requestMap.putAll(objectToMap(param,key));
             	}
             	i++;
             }
             parameters.putAll(requestMap);
             //如果涉及到修改,比对变化
//             if (bussinessName.indexOf("修改") != -1 || bussinessName.indexOf("编辑") != -1 || bussinessName.indexOf("更新") != -1) {
//                 Object obj1 = LogObjectHolder.me().get();
//                 msg = Contrast.contrastObj(dictClass, key, obj1, parameters);
//             } else {
//                 AbstractDictMap dictMap = (AbstractDictMap) dictClass.newInstance();
//                 msg = Contrast.parseMutiKey(dictMap,key,parameters);
//             }
             AbstractDictMap dictMap = (AbstractDictMap) dictClass.newInstance();
             msg = Contrast.parseMutiKey(dictMap,key,parameters);
        } 
        
        LogManager.me().executeLog(LogTaskFactory.bussinessLog(user.getId(), bussinessName, className, methodName, msg));
    }
    
    /**
     * 获取利用反射获取类里面的值和名称
     *
     * @param obj
     * @return
     * @throws IllegalAccessException
     */
    public static Map<Object, Object> objectToMap(Object obj,String key) throws IllegalAccessException {
        Map<Object, Object> map = new HashMap<>();
        Class<?> clazz = obj.getClass();
       for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Object value = field.get(obj);
            if (key.contains(fieldName)) {
            	map.put(fieldName, value);
            }
        }
        return map;
    }
}