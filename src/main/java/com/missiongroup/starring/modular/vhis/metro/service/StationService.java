package com.missiongroup.starring.modular.vhis.metro.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.metro.domain.Station;

public interface StationService {
	<S extends Station> S save(S entity);

	Station findOneByUuid(String uuid);

	Page<Station> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Station> findAll();
}
