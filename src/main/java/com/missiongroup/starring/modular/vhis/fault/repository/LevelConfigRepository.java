package com.missiongroup.starring.modular.vhis.fault.repository;

import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/5
 */
public interface LevelConfigRepository extends JpaRepository<LevelConfig, String>, JpaSpecificationExecutor<LevelConfig> {

    List<LevelConfig> findByFaultLevel(String faultLevel);

    List<LevelConfig> findByIcon(String icon);
}
