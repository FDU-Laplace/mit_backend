package com.missiongroup.starring.modular.vhis.metro.domain.dto.warpper;

import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.vhis.metro.domain.ConfigInfo;
import com.missiongroup.starring.modular.vhis.metro.domain.dto.ConfigInfoDto;

import java.util.Map;

public class ConfigInfoWrapper extends BaseWarpper {

    public ConfigInfoWrapper(Object obj) {
        super(obj);
    }

    @Override
    protected Object warpTheEntity(Object entity) {
        if (entity instanceof ConfigInfo) {
            ConfigInfoDto configInfoDto = new ConfigInfoDto();
            ConfigInfo configInfo = (ConfigInfo) entity;

            configInfoDto.setId(configInfo.getUuid());
            configInfoDto.setName(configInfo.getName());
            configInfoDto.setNumber(configInfo.getNumber());
            configInfoDto.setPort(configInfo.getPort());
            configInfoDto.setField(configInfo.getField());
            configInfoDto.setComment(configInfo.getComment());

            configInfoDto.setCreateUserId(configInfo.getCreateUserId());
            configInfoDto.setCreateTime(configInfo.getCreateTime());
            configInfoDto.setUpdateUserId(configInfo.getUpdateUserId());
            configInfoDto.setUpdateTime(configInfo.getUpdateTime());

            return configInfoDto;
        }
        return null;
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {

    }
}
