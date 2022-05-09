package com.missiongroup.starring.modular.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.LoginLog;

public interface LoginLogService {
	<S extends LoginLog> S save(S entity);

	LoginLog findOneByUuid(String uuid);

	List<LoginLog> findByUuids(String uuids);

	void delete(String uuids);

	Page<LoginLog> findAll(Pageable pageable, Map<String, Object> condition);

	String findLastLoginTime(String uuid);
}
