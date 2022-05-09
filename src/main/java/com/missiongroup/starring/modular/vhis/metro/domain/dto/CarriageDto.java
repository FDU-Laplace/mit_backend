package com.missiongroup.starring.modular.vhis.metro.domain.dto;

import com.missiongroup.starring.modular.vhis.metro.domain.Train;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: CarriageDto
 * @Description: vhis车厢DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String relationLine;
	
	private Train relationTrain;
	
	private String carriageId;
	
	private Integer carriageType;
	
	private String carriageName;
	
	private String carriageCode;
	
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

	public String getRelationLine() {
		return relationLine;
	}

	public void setRelationLine(String relationLine) {
		this.relationLine = relationLine;
	}
	
	public Train getRelationTrain() {
		return relationTrain;
	}

	public void setRelationTrain(Train relationTrain) {
		this.relationTrain = relationTrain;
	}
	
	public String getCarriageId() {
		return carriageId;
	}

	public void setCarriageId(String carriageId) {
		this.carriageId = carriageId;
	}
	
	public Integer getCarriageType() {
		return carriageType;
	}

	public void setCarriageType(Integer carriageType) {
		this.carriageType = carriageType;
	}
	
	public String getCarriageName() {
		return carriageName;
	}

	public void setCarriageName(String carriageName) {
		this.carriageName = carriageName;
	}
	
	public String getCarriageCode() {
		return carriageCode;
	}

	public void setCarriageCode(String carriageCode) {
		this.carriageCode = carriageCode;
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
