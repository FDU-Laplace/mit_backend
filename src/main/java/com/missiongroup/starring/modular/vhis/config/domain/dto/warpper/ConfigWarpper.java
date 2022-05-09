package com.missiongroup.starring.modular.vhis.config.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.config.domain.Config;
import com.missiongroup.starring.modular.vhis.config.domain.dto.ConfigDto;

/**
 * 
 * @ClassName: ConfigWarpper
 * @Description: Config的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class ConfigWarpper extends BaseWarpper {
	public ConfigWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Config) {
			ConfigDto ConfigDto = new ConfigDto();
			Config Config = (Config) entity;
			ConfigDto.setId(Config.getUuid());
			ConfigDto.setConfigCode(Config.getConfigCode());
			ConfigDto.setConfigValue(Config.getConfigValue());
			ConfigDto.setRemark(Config.getRemark());
			ConfigDto.setIsCache(Config.getIsCache());
			ConfigDto.setCreateTime(Config.getCreateTime());
			ConfigDto.setUpdateTime(Config.getUpdateTime());
			ConfigDto.setCreateUserName(ConstantFactory.me().getUserNameById(Config.getCreateUserId()));
			ConfigDto.setUpdateUserName(ConstantFactory.me().getUserNameById(Config.getUpdateUserId()));
			return ConfigDto;
		}
		return null;
	}
}
