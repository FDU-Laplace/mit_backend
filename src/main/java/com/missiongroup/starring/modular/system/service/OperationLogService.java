package com.missiongroup.starring.modular.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.OperationLog;

public interface OperationLogService {
	<S extends OperationLog> S save(S entity);

	OperationLog findOneByUuid(String uuid);

	List<OperationLog> findByUuids(String uuids);

	void delete(String uuids);

	Page<OperationLog> findAll(Pageable pageable, Map<String, Object> condition);
}
