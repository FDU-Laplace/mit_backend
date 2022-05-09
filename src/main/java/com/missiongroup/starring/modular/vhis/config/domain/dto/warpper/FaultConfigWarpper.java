package com.missiongroup.starring.modular.vhis.config.domain.dto.warpper;

import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.config.domain.dto.FaultConfigDto;

import java.util.Map;

/**
 * 
 * @ClassName: FaultWarpper
 * @Description: Fault的包装类
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class FaultConfigWarpper extends BaseWarpper {
	public FaultConfigWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof FaultConfig) {
			FaultConfigDto faultConfigDto = new FaultConfigDto();
			FaultConfig faultConfig = (FaultConfig) entity;
			faultConfigDto.setId(faultConfig.getUuid());
			faultConfigDto.setCarriage(faultConfig.getCarriage());
			faultConfigDto.setFaultSys(faultConfig.getFaultSys());
			faultConfigDto.setFaultCode(faultConfig.getFaultCode());
			faultConfigDto.setFaultName(faultConfig.getFaultName());
			faultConfigDto.setFaultLevel(faultConfig.getFaultLevel());
			faultConfigDto.setFaultDescribe(faultConfig.getFaultDescribe());
			faultConfigDto.setFaultDisposal(faultConfig.getFaultDisposal());
			faultConfigDto.setCreateTime(faultConfig.getCreateTime());
			faultConfigDto.setUpdateTime(faultConfig.getUpdateTime());
			faultConfigDto.setCreateUserId(faultConfig.getCreateUserId());
			faultConfigDto.setUpdateUserId(faultConfig.getUpdateUserId());
			return faultConfigDto;
		}
		return null;
	}
}
