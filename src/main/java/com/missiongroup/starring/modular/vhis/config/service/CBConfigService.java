package com.missiongroup.starring.modular.vhis.config.service;

import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface CBConfigService {
	<S extends CBConfig> S save(S entity);

	CBConfig findOneByUuid(String uuid);

	Page<CBConfig> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<CBConfig> findAll();
}
