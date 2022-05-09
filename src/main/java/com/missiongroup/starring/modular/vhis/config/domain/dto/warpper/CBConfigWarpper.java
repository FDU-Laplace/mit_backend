package com.missiongroup.starring.modular.vhis.config.domain.dto.warpper;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import com.missiongroup.starring.modular.vhis.config.domain.dto.CBConfigDto;

import java.util.Map;

/**
 * 
 * @ClassName: CBConfigWarpper
 * @Description: CBConfig的包装类
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:21:21
 *
 */
public class CBConfigWarpper extends BaseWarpper {
	public CBConfigWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof CBConfig) {
			CBConfigDto CBConfigDto = new CBConfigDto();
			CBConfig CBConfig = (CBConfig) entity;
			CBConfigDto.setId(CBConfig.getUuid());
			CBConfigDto.setName(CBConfig.getName());
			CBConfigDto.setCar(CBConfig.getCar());
			CBConfigDto.setDescription(CBConfig.getDescription());
			CBConfigDto.setCreateTime(CBConfig.getCreateTime());
			CBConfigDto.setUpdateTime(CBConfig.getUpdateTime());
			CBConfigDto.setCreateUserName(ConstantFactory.me().getUserNameById(CBConfig.getCreateUserId()));
			CBConfigDto.setUpdateUserName(ConstantFactory.me().getUserNameById(CBConfig.getUpdateUserId()));
			return CBConfigDto;
		}
		return null;
	}
}
