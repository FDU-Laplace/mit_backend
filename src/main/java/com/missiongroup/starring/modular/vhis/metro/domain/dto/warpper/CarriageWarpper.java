package com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.CarriageDto;

/**
 * 
 * @ClassName: CarriageWarpper
 * @Description: Carriage的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageWarpper extends BaseWarpper {
	public CarriageWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Carriage) {
			CarriageDto CarriageDto = new CarriageDto();
			Carriage Carriage = (Carriage) entity;
			CarriageDto.setId(Carriage.getUuid());
			CarriageDto.setRelationLine(Carriage.getRelationLine());
			CarriageDto.setRelationTrain(Carriage.getRelationTrain());
			CarriageDto.setCarriageId(Carriage.getCarriageId());
			CarriageDto.setCarriageType(Carriage.getCarriageType());
			CarriageDto.setCarriageName(Carriage.getCarriageName());
			CarriageDto.setCarriageCode(Carriage.getCarriageCode());
			CarriageDto.setCreateTime(Carriage.getCreateTime());
			CarriageDto.setUpdateTime(Carriage.getUpdateTime());
			CarriageDto.setCreateUserName(ConstantFactory.me().getUserNameById(Carriage.getCreateUserId()));
			CarriageDto.setUpdateUserName(ConstantFactory.me().getUserNameById(Carriage.getUpdateUserId()));
			return CarriageDto;
		}
		return null;
	}
}
