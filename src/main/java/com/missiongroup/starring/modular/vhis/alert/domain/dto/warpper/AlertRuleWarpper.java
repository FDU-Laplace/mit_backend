package com.missiongroup.starring.modular.vhis.alert.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.alert.domain.AlertRule;
import com.missiongroup.starring.modular.vhis.alert.domain.dto.AlertRuleDto;

/**
 * 
 * @ClassName: AlertRuleWarpper
 * @Description: AlertRule的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class AlertRuleWarpper extends BaseWarpper {
	public AlertRuleWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof AlertRule) {
			AlertRuleDto AlertRuleDto = new AlertRuleDto();
			AlertRule AlertRule = (AlertRule) entity;
			AlertRuleDto.setId(AlertRule.getUuid());
			AlertRuleDto.setRuleCode(AlertRule.getRuleCode());
			AlertRuleDto.setRuleName(AlertRule.getRuleName());
			AlertRuleDto.setRuleValue(AlertRule.getRuleValue());
			AlertRuleDto.setCreateTime(AlertRule.getCreateTime());
			AlertRuleDto.setUpdateTime(AlertRule.getUpdateTime());
			AlertRuleDto.setCreateUserName(ConstantFactory.me().getUserNameById(AlertRule.getCreateUserId()));
			AlertRuleDto.setUpdateUserName(ConstantFactory.me().getUserNameById(AlertRule.getUpdateUserId()));
			return AlertRuleDto;
		}
		return null;
	}
}
