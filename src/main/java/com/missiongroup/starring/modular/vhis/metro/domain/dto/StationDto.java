package com.missiongroup.starring.modular.vhis.metro.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: StationDto
 * @Description: vhis车站DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class StationDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String stationId;
	
	private String stationName;
	
	private String stationNameEn;
	
	private String stationNameSpell;
	
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

	public String getStationId() {
		return stationId;
	}

	public void setStationId(String stationId) {
		this.stationId = stationId;
	}
	
	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	public String getStationNameEn() {
		return stationNameEn;
	}

	public void setStationNameEn(String stationNameEn) {
		this.stationNameEn = stationNameEn;
	}
	
	public String getStationNameSpell() {
		return stationNameSpell;
	}

	public void setStationNameSpell(String stationNameSpell) {
		this.stationNameSpell = stationNameSpell;
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
