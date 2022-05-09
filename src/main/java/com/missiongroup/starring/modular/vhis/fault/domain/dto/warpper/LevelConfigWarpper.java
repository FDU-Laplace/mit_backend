package com.missiongroup.starring.modular.vhis.fault.domain.dto.warpper;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.LevelConfigDto;

import java.util.Map;

/**
 * 
 * @ClassName: LevelConfigWarpper
 * @Description: LevelConfig的包装类
 * @author zzbin
 * @date 2021年1月5日 下午3:13:41
 *
 */
public class LevelConfigWarpper extends BaseWarpper {
	public LevelConfigWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof LevelConfig) {
			LevelConfigDto levelConfigDto = new LevelConfigDto();
			LevelConfig levelConfig = (LevelConfig) entity;
			levelConfigDto.setId(levelConfig.getUuid());
			levelConfigDto.setColor(levelConfig.getColor());
			levelConfigDto.setCreateTime(levelConfig.getCreateTime());
			levelConfigDto.setFaultLevel(levelConfig.getFaultLevel());
			levelConfigDto.setLevelName(levelConfig.getLevelName());
			levelConfigDto.setTwinkle(levelConfig.getTwinkle());
			levelConfigDto.setVoice(levelConfig.getVoice());
			levelConfigDto.setUpdateTime(levelConfig.getUpdateTime());
			levelConfigDto.setMinor(levelConfig.getMinor());
			levelConfigDto.setIcon(levelConfig.getIcon());
			levelConfigDto.setBackgroundColor(levelConfig.getBackgroundColor());
			levelConfigDto.setCreateUserName(ConstantFactory.me().getUserNameById(levelConfig.getCreateUserId()));
			levelConfigDto.setUpdateUserName(ConstantFactory.me().getUserNameById(levelConfig.getUpdateUserId()));
			return levelConfigDto;
		}
		return null;
	}
}
