package com.missiongroup.starring.modular.vhis.metro.service;

import com.missiongroup.starring.modular.vhis.metro.domain.ConfigInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ConfigInfoService {

    <S extends ConfigInfo> S save(S entity);
    ConfigInfo findOneByUuid(String uuid);
    Page<ConfigInfo> findAll(Pageable pageable, Map<String, Object> condition);
    void delete(String uuids);
    List<ConfigInfo> findAll();
}
