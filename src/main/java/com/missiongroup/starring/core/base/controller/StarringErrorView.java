package com.missiongroup.starring.core.base.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 
 * @ClassName: StarringErrorView
 * @Description: 错误页面的默认跳转(例如请求404的时候,默认走这个视图解析器)
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:17:18
 *
 */
@Component("error")
public class StarringErrorView implements View {
	@Override
	public String getContentType() {
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
		httpServletRequest.getRequestDispatcher("/login").forward(httpServletRequest, httpServletResponse);
	}
}
