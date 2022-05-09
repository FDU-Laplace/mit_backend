package com.missiongroup.starring.modular.vhis.alert.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.alert.domain.Alert;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.AlertDto;

/**
 * 
 * @ClassName: AlertWarpper
 * @Description: Alert的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class AlertWarpper extends BaseWarpper {
	public AlertWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Alert) {
			AlertDto AlertDto = new AlertDto();
			Alert Alert = (Alert) entity;
			AlertDto.setId(Alert.getUuid());
			AlertDto.setAlertCode(Alert.getAlertCode());
			AlertDto.setRelationLin(Alert.getRelationLin());
			AlertDto.setRelationTrain(Alert.getRelationTrain());
			AlertDto.setAlertSys(Alert.getAlertSys());
			AlertDto.setRelationRule(Alert.getRelationRule());
			AlertDto.setAlertName(Alert.getAlertName());
			AlertDto.setAlertLevel(Alert.getAlertLevel());
			AlertDto.setIsAlert(Alert.getIsAlert());
			AlertDto.setPushStatus(Alert.getPushStatus());
			AlertDto.setAlertTime(Alert.getAlertTime());
			AlertDto.setRemarks(Alert.getRemarks());
			AlertDto.setCreateTime(Alert.getCreateTime());
			AlertDto.setUpdateTime(Alert.getUpdateTime());
			AlertDto.setCreateUserName(ConstantFactory.me().getUserNameById(Alert.getCreateUserId()));
			AlertDto.setUpdateUserName(ConstantFactory.me().getUserNameById(Alert.getUpdateUserId()));
			return AlertDto;
		}
		return null;
	}
}
