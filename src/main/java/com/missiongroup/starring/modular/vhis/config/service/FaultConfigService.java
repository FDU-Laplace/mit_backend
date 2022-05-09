package com.missiongroup.starring.modular.vhis.config.service;

import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface FaultConfigService {
	<S extends FaultConfig> S save(S entity);

	FaultConfig findOneByUuid(String uuid);

	Page<FaultConfig> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	List<FaultConfig> findByFaultCode(List<String> faultCodes);
	List<FaultConfig> findAll();
}
