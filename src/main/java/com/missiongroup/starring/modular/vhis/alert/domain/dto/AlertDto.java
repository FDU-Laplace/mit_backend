package com.missiongroup.starring.modular.vhis.alert.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: AlertDto
 * @Description: 预警DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class AlertDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String alertCode;
	
	private String relationLin;
	
	private String relationTrain;
	
	private String alertSys;
	
	private String relationRule;
	
	private String alertName;
	
	private String alertLevel;
	
	private String isAlert;
	
	private String pushStatus;
	
	private Date alertTime;
	
	private String remarks;
	
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

	public String getAlertCode() {
		return alertCode;
	}

	public void setAlertCode(String alertCode) {
		this.alertCode = alertCode;
	}
	
	public String getRelationLin() {
		return relationLin;
	}

	public void setRelationLin(String relationLin) {
		this.relationLin = relationLin;
	}
	
	public String getRelationTrain() {
		return relationTrain;
	}

	public void setRelationTrain(String relationTrain) {
		this.relationTrain = relationTrain;
	}
	
	public String getAlertSys() {
		return alertSys;
	}

	public void setAlertSys(String alertSys) {
		this.alertSys = alertSys;
	}
	
	public String getRelationRule() {
		return relationRule;
	}

	public void setRelationRule(String relationRule) {
		this.relationRule = relationRule;
	}
	
	public String getAlertName() {
		return alertName;
	}

	public void setAlertName(String alertName) {
		this.alertName = alertName;
	}
	
	public String getAlertLevel() {
		return alertLevel;
	}

	public void setAlertLevel(String alertLevel) {
		this.alertLevel = alertLevel;
	}
	
	public String getIsAlert() {
		return isAlert;
	}

	public void setIsAlert(String isAlert) {
		this.isAlert = isAlert;
	}
	
	public String getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}
	
	public Date getAlertTime() {
		return alertTime;
	}

	public void setAlertTime(Date alertTime) {
		this.alertTime = alertTime;
	}
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
