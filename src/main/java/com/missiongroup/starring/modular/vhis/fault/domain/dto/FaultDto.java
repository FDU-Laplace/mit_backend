package com.missiongroup.starring.modular.vhis.fault.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: FaultDto
 * @Description: 故障DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class FaultDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String relationLin;
	
	private String relationTrain;
	
	private String relationCarriage;
	
	private String faultSys;
	
	private String faultCode;
	
	private String faultName;
	
	private String faultLevel;
	
	private String isFault;
	
	private String confirmFault;
	
	private Date occurrenceTime;
	
	private Date confirmTime;
	
	private String remarks;
	private String duration;
	private String trainPosition;
	private String currentStation;
	private String nextStation;
	private Date createTime;
	
	private Date updateTime;
	
	private String createUserName;
	private String trainType;
	private String updateUserName;
	private String releaseStatus;
	private Date releaseTime;
	private String faultType;
	private String pushStatus;

	private String minor;
	private String color;
	private String voice;
	private String twinkle;
	private String levelName;
	private String icon;
	private String backgroundColor;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getTwinkle() {
		return twinkle;
	}

	public void setTwinkle(String twinkle) {
		this.twinkle = twinkle;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}
}
