package com.missiongroup.starring.modular.vhis.config.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: ConfigDto
 * @Description: vhis配置DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class ConfigDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String configCode;
	
	private String configValue;
	
	private String remark;
	
	private Boolean isCache;
	
	private Date createTime;
	
	private Date updateTime;
	
	private String createUserName;

	private String updateUserName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConfigCode() {
		return configCode;
	}

	public void setConfigCode(String configCode) {
		this.configCode = configCode;
	}
	
	public String getConfigValue() {
		return configValue;
	}

	public void setConfigValue(String configValue) {
		this.configValue = configValue;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public Boolean getIsCache() {
		return isCache;
	}

	public void setIsCache(Boolean isCache) {
		this.isCache = isCache;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}
}
