package com.missiongroup.starring.modular.vhis.alert.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.alert.domain.AlertRule;

public interface AlertRuleService {
	<S extends AlertRule> S save(S entity);

	AlertRule findOneByUuid(String uuid);

	Page<AlertRule> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<AlertRule> findAll();
}
