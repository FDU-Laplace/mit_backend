package com.missiongroup.starring.modular.vhis.alert.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.alert.domain.Alert;

public interface AlertService {
	<S extends Alert> S save(S entity);

	Alert findOneByUuid(String uuid);

	Page<Alert> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Alert> findAll();
}
