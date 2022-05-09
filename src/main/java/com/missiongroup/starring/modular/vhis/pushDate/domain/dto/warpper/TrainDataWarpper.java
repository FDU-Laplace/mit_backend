package com.missiongroup.starring.modular.vhis.pushDate.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.pushDate.domain.TrainData;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.TrainDataDto;

/**
 * 
 * @ClassName: TrainDataWarpper
 * @Description: TrainData的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class TrainDataWarpper extends BaseWarpper {
	public TrainDataWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof TrainData) {
			TrainDataDto TrainDataDto = new TrainDataDto();
			TrainData TrainData = (TrainData) entity;
			TrainDataDto.setId(TrainData.getUuid());
			TrainDataDto.setTs_timestamp(TrainData.getTs_timestamp());
			TrainDataDto.setLineId(TrainData.getLineId());
			TrainDataDto.setTrainId(TrainData.getTrainId());
			TrainDataDto.setStatus(TrainData.getStatus());
			TrainDataDto.setTheoreticalReception(TrainData.getTheoreticalReception());
			TrainDataDto.setCtualReception(TrainData.getCtualReception());
			TrainDataDto.setAcceptanceRate(TrainData.getAcceptanceRate());
			TrainDataDto.setLocation(TrainData.getLocation());
			TrainDataDto.setTrian_speed(TrainData.getTrian_speed());
			TrainDataDto.setTrian_net_voltage(TrainData.getTrian_net_voltage());
			TrainDataDto.setTrian_wind_pressure(TrainData.getTrian_wind_pressure());
			TrainDataDto.setTrian_brake_pressure(TrainData.getTrian_brake_pressure());
			TrainDataDto.setTrian_battery_voltage(TrainData.getTrian_battery_voltage());
			TrainDataDto.setTrian_broadcast_mode(TrainData.getTrian_broadcast_mode());
			TrainDataDto.setTrian_run_mode(TrainData.getTrian_run_mode());
			TrainDataDto.setTrian_control_mode(TrainData.getTrian_control_mode());
			TrainDataDto.setTrian_unit_energy(TrainData.getTrian_unit_energy());
			TrainDataDto.setTrian_total_energy(TrainData.getTrian_total_energy());
			TrainDataDto.setTrian_current_station(TrainData.getTrian_current_station());
			TrainDataDto.setTrian_next_station(TrainData.getTrian_next_station());
			TrainDataDto.setTrian_terminus(TrainData.getTrian_terminus());
			TrainDataDto.setTrian_RxLev(TrainData.getTrian_RxLev());
			TrainDataDto.setTrian_delivery_channel(TrainData.getTrian_delivery_channel());
			TrainDataDto.setTrian_commissioning(TrainData.getTrian_commissioning());
			TrainDataDto.setTrian_main_line(TrainData.getTrian_main_line());
			TrainDataDto.setCreateTime(TrainData.getCreateTime());
			TrainDataDto.setUpdateTime(TrainData.getUpdateTime());
			TrainDataDto.setCreateUserName(ConstantFactory.me().getUserNameById(TrainData.getCreateUserId()));
			TrainDataDto.setUpdateUserName(ConstantFactory.me().getUserNameById(TrainData.getUpdateUserId()));
			return TrainDataDto;
		}
		return null;
	}
}
