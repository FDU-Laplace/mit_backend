package com.missiongroup.starring.modular.vhis.pushDate.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.pushDate.domain.CarriageData;

public interface CarriageDataService {
	<S extends CarriageData> S save(S entity);

	CarriageData findOneByUuid(String uuid);

	Page<CarriageData> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<CarriageData> findAll();
}
