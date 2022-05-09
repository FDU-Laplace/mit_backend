package com.missiongroup.starring.modular.vhis.data.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.data.domain.Iscs;

public interface IscsService {
	<S extends Iscs> S save(S entity);

	Iscs findOneByUuid(String uuid);

	Page<Iscs> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Iscs> findAll();
	
	Iscs findOneByTrainnum(String trainnum);
}
