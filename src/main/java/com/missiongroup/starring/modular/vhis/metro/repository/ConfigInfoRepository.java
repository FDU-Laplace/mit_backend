package com.missiongroup.starring.modular.vhis.metro.repository;

import com.missiongroup.starring.modular.vhis.metro.domain.ConfigInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ConfigInfoRepository extends JpaRepository<ConfigInfo, String>, JpaSpecificationExecutor<ConfigInfo> {
}
