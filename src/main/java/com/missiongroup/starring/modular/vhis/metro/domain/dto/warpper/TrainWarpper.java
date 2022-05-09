package com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.metro.domain.Train;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.TrainDto;

/**
 * 
 * @ClassName: TrainWarpper
 * @Description: Train的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class TrainWarpper extends BaseWarpper {
	public TrainWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Train) {
			TrainDto trainDto = new TrainDto();
			Train train = (Train) entity;
			trainDto.setId(train.getUuid());
			trainDto.setRelationLine(train.getRelationLine());
			trainDto.setTrainId(train.getTrainId());
			trainDto.setTrainType(train.getTrainType());
			trainDto.setTrainName(train.getTrainName());
			trainDto.setTrainCode(train.getTrainCode());
			trainDto.setRemark(train.getRemark());
			trainDto.setCarriages(train.getCarriages());
			trainDto.setLines(train.getLines());
			trainDto.setCreateTime(train.getCreateTime());
			trainDto.setUpdateTime(train.getUpdateTime());
			trainDto.setCreateUserName(ConstantFactory.me().getUserNameById(train.getCreateUserId()));
			trainDto.setUpdateUserName(ConstantFactory.me().getUserNameById(train.getUpdateUserId()));
			return trainDto;
		}
		return null;
	}
}
