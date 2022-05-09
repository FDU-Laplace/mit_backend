package com.missiongroup.starring.modular.vhis.pushDate.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: CarriageDataDto
 * @Description: 车厢数据DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageDataDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String ts_timestamp;
	
	private String carriageId;
	
	private String carriageNum;
	
	private String trianId;
	
	private String lineId;
	
	private String dricab_activate;
	
	private String dricab_wall_door;
	
	private String dricab_escape_door;
	
	private String riding_rate;
	
	private String brake_state;
	
	private String compartment_temperature;
	
	private String humidity;
	
	private String traction;
	
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

	public String getTs_timestamp() {
		return ts_timestamp;
	}

	public void setTs_timestamp(String ts_timestamp) {
		this.ts_timestamp = ts_timestamp;
	}
	
	public String getCarriageId() {
		return carriageId;
	}

	public void setCarriageId(String carriageId) {
		this.carriageId = carriageId;
	}
	
	public String getCarriageNum() {
		return carriageNum;
	}

	public void setCarriageNum(String carriageNum) {
		this.carriageNum = carriageNum;
	}
	
	public String getTrianId() {
		return trianId;
	}

	public void setTrianId(String trianId) {
		this.trianId = trianId;
	}
	
	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	
	public String getDricab_activate() {
		return dricab_activate;
	}

	public void setDricab_activate(String dricab_activate) {
		this.dricab_activate = dricab_activate;
	}
	
	public String getDricab_wall_door() {
		return dricab_wall_door;
	}

	public void setDricab_wall_door(String dricab_wall_door) {
		this.dricab_wall_door = dricab_wall_door;
	}
	
	public String getDricab_escape_door() {
		return dricab_escape_door;
	}

	public void setDricab_escape_door(String dricab_escape_door) {
		this.dricab_escape_door = dricab_escape_door;
	}
	
	public String getRiding_rate() {
		return riding_rate;
	}

	public void setRiding_rate(String riding_rate) {
		this.riding_rate = riding_rate;
	}
	
	public String getBrake_state() {
		return brake_state;
	}

	public void setBrake_state(String brake_state) {
		this.brake_state = brake_state;
	}
	
	public String getCompartment_temperature() {
		return compartment_temperature;
	}

	public void setCompartment_temperature(String compartment_temperature) {
		this.compartment_temperature = compartment_temperature;
	}
	
	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	
	public String getTraction() {
		return traction;
	}

	public void setTraction(String traction) {
		this.traction = traction;
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
