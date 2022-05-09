package com.missiongroup.starring.modular.vhis.fault.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "vhis_fault")
public class Fault implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
	 * 唯一标识UUID
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '主键,唯一标识UUID'")
	private String uuid;

    /**
	 * 线路ID
	 */
	private String relationLin;
	
    /**
	 * 列车ID
	 */
	private String relationTrain;

    /**
	 * 车厢ID
	 */
	private String relationCarriage;
	
    /**
	 * 故障系统
	 */
	private String faultSys;
	
    /**
	 * 故障代码top
	 */
	private String faultCode;
	
    /**
	 * 故障名称
	 */
	private String faultName;
	
    /**
	 * 故障等级
	 */
	private String faultLevel;
	
    /**
	 * 是否故障
	 */
	private String isFault;
	
    /**
	 * 故障确认
	 */
	private String confirmFault;
	
    /**
	 * 发生时间
	 */
	private Date occurrenceTime;
	
    /**
	 * 确认时间
	 */
	private Date confirmTime;
	
    /**
	 * 备注
	 */
	private String remarks;

	/**
	 * 持续时间
	 */
	private String duration;
	/**
	 * 列车位置
	 */
	private String trainPosition;
	/**
	 * 当前站
	 */
	private String currentStation;
	/**
	 * 下一站
	 */
	private String nextStation;
	/**
	 * 解除状态
	 */
	private String releaseStatus;
	/**
	 * 解除时间
	 */
	private Date releaseTime;
	/**
	 * 车型
	 */
	private String trainType;
	/**
	 * 故障类型
	 */
	private String faultType;
	/**
	 * 推送类型
	 */
	private String pushStatus;
	/**
	 * 创建时间
	 */
	@Column(columnDefinition="datetime COMMENT '创建时间'")
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	@Column(columnDefinition="datetime COMMENT '修改时间'")
	private Date updateTime;

	/**
	 * 创建用户ID
	 */
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '创建用户ID'")
	private String createUserId;

	/**
	 * 修改用户ID
	 */
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '修改用户ID'")
	private String updateUserId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
	
	public String getRelationCarriage() {
		return relationCarriage;
	}

	public void setRelationCarriage(String relationCarriage) {
		this.relationCarriage = relationCarriage;
	}
	
	public String getFaultSys() {
		return faultSys;
	}

	public void setFaultSys(String faultSys) {
		this.faultSys = faultSys;
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
	
	public String getIsFault() {
		return isFault;
	}

	public void setIsFault(String isFault) {
		this.isFault = isFault;
	}
	
	public String getConfirmFault() {
		return confirmFault;
	}

	public void setConfirmFault(String confirmFault) {
		this.confirmFault = confirmFault;
	}
	
	public Date getOccurrenceTime() {
		return occurrenceTime;
	}

	public void setOccurrenceTime(Date occurrenceTime) {
		this.occurrenceTime = occurrenceTime;
	}
	
	public Date getConfirmTime() {
		return confirmTime;
	}

	public void setConfirmTime(Date confirmTime) {
		this.confirmTime = confirmTime;
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

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getTrainPosition() {
		return trainPosition;
	}

	public void setTrainPosition(String trainPosition) {
		this.trainPosition = trainPosition;
	}

	public String getCurrentStation() {
		return currentStation;
	}

	public void setCurrentStation(String currentStation) {
		this.currentStation = currentStation;
	}

	public String getNextStation() {
		return nextStation;
	}

	public void setNextStation(String nextStation) {
		this.nextStation = nextStation;
	}

	public String getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getTrainType() {
		return trainType;
	}

	public void setTrainType(String trainType) {
		this.trainType = trainType;
	}

	public String getFaultType() {
		return faultType;
	}

	public void setFaultType(String faultType) {
		this.faultType = faultType;
	}

	public String getPushStatus() {
		return pushStatus;
	}

	public void setPushStatus(String pushStatus) {
		this.pushStatus = pushStatus;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
}
