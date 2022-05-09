package com.missiongroup.starring.modular.vhis.config.repository;

import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FaultConfigRepository extends JpaRepository<FaultConfig, String>, JpaSpecificationExecutor<FaultConfig> {

    List<FaultConfig> findAllByFaultCodeIn(List<String> faultCodes);

    @Query(value = "from FaultConfig f where f.levelConfig.uuid = :levelId")
    List<FaultConfig> findByLevelConfigId(@Param("levelId") String levelId);

    @Modifying
    @Query(value = "update vhis_faultconfig set levelconf_uuid = null where uuid = ?1", nativeQuery = true)
    void updateByUUid(String uuid);
}
