package com.missiongroup.starring.modular.vhis.config.repository;


import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CBConfigRepository extends JpaRepository<CBConfig, String>, JpaSpecificationExecutor<CBConfig> {

}
