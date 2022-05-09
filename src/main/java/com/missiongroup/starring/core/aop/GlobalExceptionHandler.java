package com.missiongroup.starring.core.aop;

import static com.missiongroup.starring.core.support.HttpKit.getIp;
import static com.missiongroup.starring.core.support.HttpKit.getRequest;

import java.lang.reflect.UndeclaredThrowableException;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.UnknownSessionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.thymeleaf.exceptions.TemplateInputException;

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.common.exception.InvalidKaptchaException;
import com.missiongroup.starring.common.exception.NettyConnectErrorException;
import com.missiongroup.starring.common.exception.NotAssignRolesException;
import com.missiongroup.starring.common.exception.ResourceUploadErrorException;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.log.LogManager;
import com.missiongroup.starring.core.log.factory.LogTaskFactory;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.support.HttpKit;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @author mission
 * @date 2016年11月12日 下午3:19:56
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    
    /** 拦截未找到页面异常
     * @param e
     * @return
     */
    @ExceptionHandler(TemplateInputException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorTip noFindPage(TemplateInputException e) {
    	log.error("业务异常:", e.getMessage());
    	return new ErrorTip(404, "未找到页面");
    }
    
    /**
     * 拦截无权限访问异常
     *
     * @author mission
     */
    @ExceptionHandler(NoPermissionException.class)
    @ResponseStatus(HttpStatus.OK)
    public String noPermissionError(NoPermissionException e) {
    	return "forward:/globalCtl/error/noPermission";
    }
    /**
     * 拦截业务异常
     *
     * @author mission
     */
    @ExceptionHandler(BussinessException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip requestParamError(BussinessException e) {
    	log.error("业务异常:", e.getMessage());
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        return new ErrorTip(Integer.valueOf(e.getCode()), e.getMessage());
    }

    /**
     * 用户未登录
     *
     * @author mission
     */
    @ExceptionHandler(AuthenticationException.class)
    @ResponseStatus(HttpStatus.OK)
    public String noLogin(AuthenticationException e) {
        log.error("用户未登陆：", e.getMessage());
        return "forward:/globalCtl/error/noLogin";
    }
    
    /**
     * 用户未分配角色异常
     *
     * @author mission
     */
    @ExceptionHandler(NotAssignRolesException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip notAssginRoles(NotAssignRolesException e) {
    	log.error("用户未分配角色:", e.getMessage());
    	String username = getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "用户没有分配角色", getIp()));
        return new ErrorTip(Integer.valueOf(e.getCode()), e.getMessage());
    }

    /**
     * 账号被冻结
     *
     * @author mission
     */
    @ExceptionHandler(DisabledAccountException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip accountLocked(DisabledAccountException e) {
    	log.error("账号被冻结:", e.getMessage());
        String username = getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号被冻结", getIp()));
        ErrorTip errorTip = new ErrorTip(Integer.valueOf(BizExceptionEnum.ACCOUNT_FREEZED.getCode()),BizExceptionEnum.ACCOUNT_FREEZED.getMessage());
        return errorTip;
    }

    /**
     * 账号密码错误
     *
     * @author mission
     */
    @ExceptionHandler(CredentialsException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip credentials(CredentialsException e, Model model) {
    	log.error("账号或密码错误:", e.getMessage());
        //System.out.println("sdrhbdrsbrsf");
        String username = getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "账号密码错误", getIp()));
        boolean flag = onLoginFail();
        ErrorTip errorTip = new ErrorTip(Integer.valueOf(BizExceptionEnum.USER_OR_PASSWORD_ERROR.getCode()),BizExceptionEnum.USER_OR_PASSWORD_ERROR.getMessage());
        errorTip.setKaptcha(flag);
        return errorTip;
    }

    /**
     * 验证码错误
     *
     * @author mission
     */
    @ExceptionHandler(InvalidKaptchaException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip credentials(InvalidKaptchaException e) {
    	log.error("验证码错误:", e.getMessage());
        String username = getRequest().getParameter("username");
        LogManager.me().executeLog(LogTaskFactory.loginLog(username, "验证码错误", getIp()));
        boolean flag = onLoginFail();
        ErrorTip errorTip = new ErrorTip(Integer.valueOf(e.getCode()), e.getMessage());
        errorTip.setKaptcha(flag);
        return errorTip;
    }

    /**
     * 无权访问该资源
     *
     * @author mission
     */
    @ExceptionHandler(UndeclaredThrowableException.class)
    @ResponseStatus(HttpStatus.OK)
    public String credentials(UndeclaredThrowableException e) {
    	log.error("权限异常!", e.getMessage());
    	return "forward:/globalCtl/error/noPermission";
    }

    /**
     * 拦截未知的运行时异常
     *
     * @author mission
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip unKnownException(RuntimeException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        log.error("运行时异常:", e);
        return new ErrorTip(Integer.valueOf(BizExceptionEnum.SERVER_ERROR.getCode()),BizExceptionEnum.SERVER_ERROR.getMessage());
    }
    
    /**
     * 资源上传失败异常
     *
     * @author mission
     */
    @ExceptionHandler(ResourceUploadErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public void uploadError(ResourceUploadErrorException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
    }
    
    /**
     * 拦截未知的运行时异常
     *
     * @author mission
     */
    @ExceptionHandler(NettyConnectErrorException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ErrorTip nettyConnectError(NettyConnectErrorException e) {
        LogManager.me().executeLog(LogTaskFactory.exceptionLog(ShiroKit.getUser().getId(), e));
        log.error("运行时异常:", e);
        return new ErrorTip(Integer.valueOf(e.getCode()),e.getMessage());
    }

    /**
     * session失效的异常拦截
     *
     * @author mission
     * @Date 2017/6/7 21:02
     */
    @ExceptionHandler(InvalidSessionException.class)
    @ResponseStatus(HttpStatus.OK)
    public String sessionTimeout(InvalidSessionException e, HttpServletRequest request, HttpServletResponse response) {
    	log.error("运行时异常:", e.getMessage());
        assertAjax(request, response);
        return "forward:/globalCtl/sessionError";
    }

    /**
     * session异常
     *
     * @author mission
     * @Date 2017/6/7 21:02
     */
    @ExceptionHandler(UnknownSessionException.class)
    @ResponseStatus(HttpStatus.OK)
    public String sessionTimeout(UnknownSessionException e, HttpServletRequest request, HttpServletResponse response) {
    	log.error("运行时异常:", e.getMessage());
        assertAjax(request, response);
        return "forward:/globalCtl/sessionError";
    }

    private void assertAjax(HttpServletRequest request, HttpServletResponse response) {
        if (request.getHeader("x-requested-with") != null
                && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
            //如果是ajax请求响应头会有，x-requested-with
            response.setHeader("sessionstatus", "timeout");//在响应头设置session状态
        }
    }
    
    private boolean onLoginFail() {
    	Integer loginNum = (Integer) HttpKit.getRequest().getSession().getAttribute("loginNum");
    	if(loginNum == null) {
    		loginNum = 1;
    	}else {
    		loginNum++;
    	}
    	HttpKit.getRequest().getSession().setAttribute("loginNum", loginNum);
    	return loginNum >= 3;
    }

}
