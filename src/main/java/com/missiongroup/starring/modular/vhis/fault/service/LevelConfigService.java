package com.missiongroup.starring.modular.vhis.fault.service;

import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface LevelConfigService {
    <S extends LevelConfig> S save(S entity);

    List saveAll(LinkedList levelConfs);

    void updatelevelConfData(String levelConf);

    LevelConfig findOneByUuid(String uuid);

    Page<LevelConfig> findAll(Pageable pageable, Map<String, Object> condition);

    void delete(String uuids);

    List<LevelConfig> findAll();

    void confirm(String uuids);

    List<LevelConfig> findByFaultLevel(String level);

    List<LevelConfig> findByIcon(String icon);

    List<FaultDto> findLevelConfigJoinFault(List<FaultDto> dto);
}
