package com.missiongroup.starring.modular.vhis.alert.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.missiongroup.starring.modular.vhis.alert.domain.AlertRule;

public interface AlertRuleRepository extends JpaRepository<AlertRule, String>, JpaSpecificationExecutor<AlertRule> {

}
