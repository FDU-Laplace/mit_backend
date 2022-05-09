package com.missiongroup.starring.core.beetl;

import org.beetl.ext.spring.BeetlGroupUtilConfiguration;

import com.missiongroup.starring.core.util.KaptchaUtil;
import com.missiongroup.starring.core.util.ToolUtil;

public class BeetlConfiguration extends BeetlGroupUtilConfiguration {
	@Override
	public void initOther() {
		groupTemplate.registerFunctionPackage("shiro", new ShiroExt());
		groupTemplate.registerFunctionPackage("tool", new ToolUtil());
		groupTemplate.registerFunctionPackage("kaptcha", new KaptchaUtil());
	}
}
