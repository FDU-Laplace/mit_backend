package com.missiongroup.starring.core.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ConfigListener implements ServletContextListener {
	private static Map<String, String> conf = new HashMap<>();

	public static Map<String, String> getConf() {
		return conf;
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		conf.clear();
	}

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		// 项目路径
		conf.put("realPath", servletContext.getRealPath("/").replaceFirst("/", ""));
		conf.put("contextPath", servletContext.getContextPath());
	}
}
