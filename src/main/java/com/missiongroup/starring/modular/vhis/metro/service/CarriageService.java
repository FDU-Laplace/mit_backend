package com.missiongroup.starring.modular.vhis.metro.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;

public interface CarriageService {
	<S extends Carriage> S save(S entity);

	Carriage findOneByUuid(String uuid);

	Page<Carriage> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Carriage> findAll();
}
