package com.missiongroup.starring.core.intercept;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.session.InvalidSessionException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.ResourceUploadErrorException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.support.HttpKit;

import javax.servlet.http.Cookie;

/**
 * 
 * @ClassName: SessionTimeoutInterceptor
 * @Description: 验证session超时的拦截器
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:06:09
 *
 */
@Aspect
@Component
@ConditionalOnProperty(prefix = "starring", name = "session-open", havingValue = "true")
public class SessionTimeoutInterceptor extends BaseController {
	@Pointcut("execution(* com.missiongroup.starring.*..controller.*.*(..))")
	public void cutService() {

	}

	@Around("cutService()")
	public Object sessionTimeoutValidate(ProceedingJoinPoint point) throws Throwable {
		String servletPath = HttpKit.getRequest().getServletPath();
		List<String> ignoreUrls = new ArrayList<String>();

		if (servletPath.equals("/error")) {
			servletPath = "/login";
			Cookie newCookie = new Cookie("shiroCookie_vhis", null);
			newCookie.setMaxAge(0);
			newCookie.setPath("/");
			HttpKit.getResponse().addCookie(newCookie);
		}

		ignoreUrls.add("/kaptchaCtl");
		ignoreUrls.add("/login");
		ignoreUrls.add("/doc.html");
		ignoreUrls.add("/swagger-resources/**");
		ignoreUrls.add("/v2/api-docs/**");
		ignoreUrls.add("/globalCtl/sessionError");
		ignoreUrls.add("/globalCtl/error");
		ignoreUrls.add("/DataSocket/preparationScreen");
		if (ignoreUrls.contains(servletPath)) {
			return point.proceed();
		} else {
			if (null == ShiroKit.getSession().getAttribute("sessionFlag")) {
				ShiroKit.getSubject().logout();
				throw new InvalidSessionException();
			} else {
				if("/resourceCtl/upload".equals(servletPath)) {
					try {
						return point.proceed();
					} catch (Exception e) {
						throw new ResourceUploadErrorException(BizExceptionEnum.RESOURCE_UPLOAD_ERROR);
					}
				} else {
					return point.proceed();
				}
			}
		}
	}
}
