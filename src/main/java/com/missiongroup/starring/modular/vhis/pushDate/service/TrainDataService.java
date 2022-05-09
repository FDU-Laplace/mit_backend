package com.missiongroup.starring.modular.vhis.pushDate.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.pushDate.domain.TrainData;

public interface TrainDataService {
	<S extends TrainData> S save(S entity);

	TrainData findOneByUuid(String uuid);

	Page<TrainData> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<TrainData> findAll();
}
