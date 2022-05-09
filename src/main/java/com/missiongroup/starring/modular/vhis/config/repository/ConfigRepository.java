package com.missiongroup.starring.modular.vhis.config.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.missiongroup.starring.modular.vhis.config.domain.Config;

public interface ConfigRepository extends JpaRepository<Config, String>, JpaSpecificationExecutor<Config> {

}
