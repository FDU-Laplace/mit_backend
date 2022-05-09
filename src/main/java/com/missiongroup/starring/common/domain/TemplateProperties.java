package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.List;

public class TemplateProperties implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 项目主目录
	 */
	private String projectPath;

	/**
	 * 功能名称
	 */
	private String functionName;

	/**
	 * 实体名称(如:Domain)
	 */
	private String domainName;

	/**
	 * modular下的根模块名称(如:pcc)
	 */
	private String moduleName;

	/**
	 * 子模块名称(如:resource)
	 */
	private String subModuleName;

	/**
	 * 实体(属性, 类型)List(如:[String, Name, name, 姓名])
	 */
	private List<PropertyObject> properties;

	/**
	 * 模块描述
	 */
	private String moduleDescription;

	/**
	 * 实体描述
	 */
	private String domainDescription;

	/**
	 * AOP记录日志的实体属性
	 */
	private String logProperties;

	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getSubModuleName() {
		return subModuleName;
	}

	public void setSubModuleName(String subModuleName) {
		this.subModuleName = subModuleName;
	}

	public List<PropertyObject> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyObject> properties) {
		this.properties = properties;
	}

	public String getModuleDescription() {
		return moduleDescription;
	}

	public void setModuleDescription(String moduleDescription) {
		this.moduleDescription = moduleDescription;
	}

	public String getDomainDescription() {
		return domainDescription;
	}

	public void setDomainDescription(String domainDescription) {
		this.domainDescription = domainDescription;
	}

	public String getLogProperties() {
		return logProperties;
	}

	public void setLogProperties(String logProperties) {
		this.logProperties = logProperties;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
}
