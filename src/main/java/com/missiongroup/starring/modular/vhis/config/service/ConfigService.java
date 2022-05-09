package com.missiongroup.starring.modular.vhis.config.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.config.domain.Config;

public interface ConfigService {
	<S extends Config> S save(S entity);

	Config findOneByUuid(String uuid);

	Page<Config> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Config> findAll();
}
