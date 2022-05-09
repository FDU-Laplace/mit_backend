package com.missiongroup.starring.modular.vhis.config.domain.dto;

import java.io.Serializable;
import java.util.Date;


public class FaultConfigDto implements Serializable {
	private static final long serialVersionUID = 1L;


	private String id;


	private String faultCode;
	

	private String faultName;

	private String faultLevel;


	private String faultDescribe;
	private String faultSys;

	private String faultDisposal;
	private String carriage;

	private Date createTime;
	

	private Date updateTime;


	private String createUserId;


	private String updateUserId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFaultCode() {
		return faultCode;
	}

	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	
	public String getFaultName() {
		return faultName;
	}

	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}
	
	public String getFaultLevel() {
		return faultLevel;
	}

	public void setFaultLevel(String faultLevel) {
		this.faultLevel = faultLevel;
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getFaultDescribe() {
		return faultDescribe;
	}

	public void setFaultDescribe(String faultDescribe) {
		this.faultDescribe = faultDescribe;
	}

	public String getFaultDisposal() {
		return faultDisposal;
	}

	public void setFaultDisposal(String faultDisposal) {
		this.faultDisposal = faultDisposal;
	}

	public String getCarriage() {
		return carriage;
	}

	public void setCarriage(String carriage) {
		this.carriage = carriage;
	}

	public String getFaultSys() {
		return faultSys;
	}

	public void setFaultSys(String faultSys) {
		this.faultSys = faultSys;
	}
}
