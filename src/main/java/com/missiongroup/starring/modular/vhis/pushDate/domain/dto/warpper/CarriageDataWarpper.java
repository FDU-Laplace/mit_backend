package com.missiongroup.starring.modular.vhis.pushDate.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.pushDate.domain.CarriageData;
import com.missiongroup.starring.modular.vhis.pushDate.domain.dto.CarriageDataDto;

/**
 * 
 * @ClassName: CarriageDataWarpper
 * @Description: CarriageData的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageDataWarpper extends BaseWarpper {
	public CarriageDataWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof CarriageData) {
			CarriageDataDto CarriageDataDto = new CarriageDataDto();
			CarriageData CarriageData = (CarriageData) entity;
			CarriageDataDto.setId(CarriageData.getUuid());
			CarriageDataDto.setTs_timestamp(CarriageData.getTs_timestamp());
			CarriageDataDto.setCarriageId(CarriageData.getCarriageId());
			CarriageDataDto.setCarriageNum(CarriageData.getCarriageNum());
			CarriageDataDto.setTrianId(CarriageData.getTrianId());
			CarriageDataDto.setLineId(CarriageData.getLineId());
			CarriageDataDto.setDricab_activate(CarriageData.getDricab_activate());
			CarriageDataDto.setDricab_wall_door(CarriageData.getDricab_wall_door());
			CarriageDataDto.setDricab_escape_door(CarriageData.getDricab_escape_door());
			CarriageDataDto.setRiding_rate(CarriageData.getRiding_rate());
			CarriageDataDto.setBrake_state(CarriageData.getBrake_state());
			CarriageDataDto.setCompartment_temperature(CarriageData.getCompartment_temperature());
			CarriageDataDto.setHumidity(CarriageData.getHumidity());
			CarriageDataDto.setTraction(CarriageData.getTraction());
			CarriageDataDto.setCreateTime(CarriageData.getCreateTime());
			CarriageDataDto.setUpdateTime(CarriageData.getUpdateTime());
			CarriageDataDto.setCreateUserName(ConstantFactory.me().getUserNameById(CarriageData.getCreateUserId()));
			CarriageDataDto.setUpdateUserName(ConstantFactory.me().getUserNameById(CarriageData.getUpdateUserId()));
			return CarriageDataDto;
		}
		return null;
	}
}
