package com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.metro.domain.Station;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.StationDto;

/**
 * 
 * @ClassName: StationWarpper
 * @Description: Station的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class StationWarpper extends BaseWarpper {
	public StationWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Station) {
			StationDto StationDto = new StationDto();
			Station Station = (Station) entity;
			StationDto.setId(Station.getUuid());
			StationDto.setStationId(Station.getStationId());
			StationDto.setStationName(Station.getStationName());
			StationDto.setStationNameEn(Station.getStationNameEn());
			StationDto.setStationNameSpell(Station.getStationNameSpell());
			StationDto.setCreateTime(Station.getCreateTime());
			StationDto.setUpdateTime(Station.getUpdateTime());
			StationDto.setCreateUserName(ConstantFactory.me().getUserNameById(Station.getCreateUserId()));
			StationDto.setUpdateUserName(ConstantFactory.me().getUserNameById(Station.getUpdateUserId()));
			return StationDto;
		}
		return null;
	}
}
