package com.missiongroup.starring.modular.vhis.pushDate.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: TrainDataDto
 * @Description: 列车数据DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class TrainDataDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String ts_timestamp;
	
	private String lineId;
	
	private String trainId;
	
	private String status;
	
	private String theoreticalReception;
	
	private String ctualReception;
	
	private String acceptanceRate;
	
	private String location;
	
	private String trian_speed;
	
	private String trian_net_voltage;
	
	private String trian_wind_pressure;
	
	private String trian_brake_pressure;
	
	private String trian_battery_voltage;
	
	private String trian_broadcast_mode;
	
	private String trian_run_mode;
	
	private String trian_control_mode;
	
	private String trian_unit_energy;
	
	private String trian_total_energy;
	
	private String trian_current_station;
	
	private String trian_next_station;
	
	private String trian_terminus;
	
	private String trian_RxLev;
	
	private String trian_delivery_channel;
	
	private String trian_commissioning;
	
	private String trian_main_line;
	
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
