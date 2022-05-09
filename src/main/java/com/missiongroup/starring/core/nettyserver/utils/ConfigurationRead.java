package com.missiongroup.starring.core.nettyserver.utils;

import java.io.InputStreamReader;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * <Description> ConfigurationRead 属性文件读取类
 * 
 * @author TAIHUAYUN
 * @version 1.0
 * @CreateDate 2016-6-26
 */
public class ConfigurationRead {
	private static Logger logger = Logger.getLogger(ConfigurationRead.class);

	private String propertyFile = "config.properties";

	private static volatile ConfigurationRead CFG_INSTANCE;

	private Properties properties = new Properties();

	private ConfigurationRead() {
		try {
			properties.load(new InputStreamReader(getClass().getResourceAsStream("/" + propertyFile), "UTF-8"));
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public static ConfigurationRead getInstance() {
		if (CFG_INSTANCE == null) {
			synchronized (ConfigurationRead.class) {
				if (CFG_INSTANCE == null) {
					CFG_INSTANCE = new ConfigurationRead();
				}
			}
		}
		return CFG_INSTANCE;
	}

	/**
	 * Key取值
	 * 
	 * @param strKey
	 *            String
	 * @return String
	 */
	public String getValue(String strKey) {
		return properties.getProperty(strKey);
	}

}
