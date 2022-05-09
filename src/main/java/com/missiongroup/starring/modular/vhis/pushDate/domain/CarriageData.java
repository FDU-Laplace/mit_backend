package com.missiongroup.starring.modular.vhis.pushDate.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "vhis_carriagedata")
public class CarriageData implements Serializable {
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
	 * 时间
	 */
	private String ts_timestamp;
	
    /**
	 * 车厢id
	 */
	private String carriageId;
	
    /**
	 * 车厢编号
	 */
	private String carriageNum;
	
    /**
	 * 车辆id
	 */
	private String trianId;
	
    /**
	 * 线路ID
	 */
	private String lineId;
	
    /**
	 * 司机室激活端
	 */
	private String dricab_activate;
	
    /**
	 * 司机室壁门
	 */
	private String dricab_wall_door;
	
    /**
	 * 司机室逃生门
	 */
	private String dricab_escape_door;
	
    /**
	 * 乘车率
	 */
	private String riding_rate;
	
    /**
	 * 制动状态
	 */
	private String brake_state;
	
    /**
	 * 客室温度
	 */
	private String compartment_temperature;
	
    /**
	 * 湿度
	 */
	private String humidity;
	
    /**
	 * 牵引力30%
	 */
	private String traction;
	
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
}
