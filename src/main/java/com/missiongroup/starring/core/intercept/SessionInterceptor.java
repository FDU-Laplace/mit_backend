package com.missiongroup.starring.core.intercept;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.util.HttpSessionHolder;

/**
 * 
 * @ClassName: SessionInterceptor
 * @Description: 静态调用session的拦截器
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:05:49
 *
 */
@Aspect
@Component
public class SessionInterceptor extends BaseController {
	@Pointcut("execution(* com.missiongroup.starring.*..controller.*.*(..))")
	public void cutService() {

	}

	@Around("cutService()")
	public Object sessionKit(ProceedingJoinPoint point) throws Throwable {
		HttpSessionHolder.put(super.getHttpServletRequest().getSession());
		try {
			return point.proceed();
		} finally {
			HttpSessionHolder.remove();
		}
	}
}
