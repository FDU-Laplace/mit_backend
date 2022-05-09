package com.missiongroup.starring.core.shiro.factory;

import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

public class ShiroFormAuthenticationFilter extends FormAuthenticationFilter {
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (this.isLoginRequest(request, response)) {
			if (this.isLoginSubmission(request, response)) {
				return this.executeLogin(request, response);
			} else {
				return true;
			}
		} else {
			String header = ((HttpServletRequest) request).getHeader("Authorization");
			if (header != null && (header.equals("ajax_authorization"))) {
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				out.print("{\"code\" : 401, \"message\":\"登录失效，请重新登录\" }");
				out.flush();
				out.close();
			} else {
				this.saveRequestAndRedirectToLogin(request, response);
			}
			return false;
		}
	}

}
