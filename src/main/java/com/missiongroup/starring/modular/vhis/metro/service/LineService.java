package com.missiongroup.starring.modular.vhis.metro.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.metro.domain.Line;

public interface LineService {
	<S extends Line> S save(S entity);

	Line findOneByUuid(String uuid);

	Page<Line> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Line> findAll();
}
