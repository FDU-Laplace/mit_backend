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
@Table(name = "vhis_traindata")
public class TrainData implements Serializable {
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
	 * 创建时间
	 */
	private String ts_timestamp;
	
    /**
	 * 线路ID
	 */
	private String lineId;
	
    /**
	 * 列车ID
	 */
	private String trainId;
	
    /**
	 * 状态 0：离线，1：在线
	 */
	private String status;
	
    /**
	 * 理论接收
	 */
	private String theoreticalReception;
	
    /**
	 * 实际接收
	 */
	private String ctualReception;
	
    /**
	 * 接收率
	 */
	private String acceptanceRate;
	
    /**
	 * 行驶位置 (0 地下1 涵洞2 地上)
	 */
	private String location;
	
    /**
	 * 速度 km/h
	 */
	private String trian_speed;
	
    /**
	 * 网压 V
	 */
	private String trian_net_voltage;
	
    /**
	 * 主风压力 bar
	 */
	private String trian_wind_pressure;
	
    /**
	 * 制动压力 bar
	 */
	private String trian_brake_pressure;
	
    /**
	 * 蓄电池电压 V
	 */
	private String trian_battery_voltage;
	
    /**
	 * 报站模式(0 自动;1 手动)
	 */
	private String trian_broadcast_mode;
	
    /**
	 * 运行模式(0 惰性；)
	 */
	private String trian_run_mode;
	
    /**
	 * 控制模式(0 AIO 模式 ；)
	 */
	private String trian_control_mode;
	
    /**
	 * 单位耗能 kWh/km
	 */
	private String trian_unit_energy;
	
    /**
	 * 总耗能 kWh
	 */
	private String trian_total_energy;
	
    /**
	 * 当前站
	 */
	private String trian_current_station;
	
    /**
	 * 下一站
	 */
	private String trian_next_station;
	
    /**
	 * 终点站
	 */
	private String trian_terminus;
	
    /**
	 * 信号强度 0：弱 1：中 2：强
	 */
	private String trian_RxLev;
	
    /**
	 * 传输通道
	 */
	private String trian_delivery_channel;
	
    /**
	 * 是否投运 1:是 0：否
	 */
	private String trian_commissioning;
	
    /**
	 * 是否正线1:是 0：否
	 */
	private String trian_main_line;
	
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
	
	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	
	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getTheoreticalReception() {
		return theoreticalReception;
	}

	public void setTheoreticalReception(String theoreticalReception) {
		this.theoreticalReception = theoreticalReception;
	}
	
	public String getCtualReception() {
		return ctualReception;
	}

	public void setCtualReception(String ctualReception) {
		this.ctualReception = ctualReception;
	}
	
	public String getAcceptanceRate() {
		return acceptanceRate;
	}

	public void setAcceptanceRate(String acceptanceRate) {
		this.acceptanceRate = acceptanceRate;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getTrian_speed() {
		return trian_speed;
	}

	public void setTrian_speed(String trian_speed) {
		this.trian_speed = trian_speed;
	}
	
	public String getTrian_net_voltage() {
		return trian_net_voltage;
	}

	public void setTrian_net_voltage(String trian_net_voltage) {
		this.trian_net_voltage = trian_net_voltage;
	}
	
	public String getTrian_wind_pressure() {
		return trian_wind_pressure;
	}

	public void setTrian_wind_pressure(String trian_wind_pressure) {
		this.trian_wind_pressure = trian_wind_pressure;
	}
	
	public String getTrian_brake_pressure() {
		return trian_brake_pressure;
	}

	public void setTrian_brake_pressure(String trian_brake_pressure) {
		this.trian_brake_pressure = trian_brake_pressure;
	}
	
	public String getTrian_battery_voltage() {
		return trian_battery_voltage;
	}

	public void setTrian_battery_voltage(String trian_battery_voltage) {
		this.trian_battery_voltage = trian_battery_voltage;
	}
	
	public String getTrian_broadcast_mode() {
		return trian_broadcast_mode;
	}

	public void setTrian_broadcast_mode(String trian_broadcast_mode) {
		this.trian_broadcast_mode = trian_broadcast_mode;
	}
	
	public String getTrian_run_mode() {
		return trian_run_mode;
	}

	public void setTrian_run_mode(String trian_run_mode) {
		this.trian_run_mode = trian_run_mode;
	}
	
	public String getTrian_control_mode() {
		return trian_control_mode;
	}

	public void setTrian_control_mode(String trian_control_mode) {
		this.trian_control_mode = trian_control_mode;
	}
	
	public String getTrian_unit_energy() {
		return trian_unit_energy;
	}

	public void setTrian_unit_energy(String trian_unit_energy) {
		this.trian_unit_energy = trian_unit_energy;
	}
	
	public String getTrian_total_energy() {
		return trian_total_energy;
	}

	public void setTrian_total_energy(String trian_total_energy) {
		this.trian_total_energy = trian_total_energy;
	}
	
	public String getTrian_current_station() {
		return trian_current_station;
	}

	public void setTrian_current_station(String trian_current_station) {
		this.trian_current_station = trian_current_station;
	}
	
	public String getTrian_next_station() {
		return trian_next_station;
	}

	public void setTrian_next_station(String trian_next_station) {
		this.trian_next_station = trian_next_station;
	}
	
	public String getTrian_terminus() {
		return trian_terminus;
	}

	public void setTrian_terminus(String trian_terminus) {
		this.trian_terminus = trian_terminus;
	}
	
	public String getTrian_RxLev() {
		return trian_RxLev;
	}

	public void setTrian_RxLev(String trian_RxLev) {
		this.trian_RxLev = trian_RxLev;
	}
	
	public String getTrian_delivery_channel() {
		return trian_delivery_channel;
	}

	public void setTrian_delivery_channel(String trian_delivery_channel) {
		this.trian_delivery_channel = trian_delivery_channel;
	}
	
	public String getTrian_commissioning() {
		return trian_commissioning;
	}

	public void setTrian_commissioning(String trian_commissioning) {
		this.trian_commissioning = trian_commissioning;
	}
	
	public String getTrian_main_line() {
		return trian_main_line;
	}

	public void setTrian_main_line(String trian_main_line) {
		this.trian_main_line = trian_main_line;
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
