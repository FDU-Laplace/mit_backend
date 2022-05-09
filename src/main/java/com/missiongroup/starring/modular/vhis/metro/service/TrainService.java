package com.missiongroup.starring.modular.vhis.metro.service;

import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.metro.domain.Train;

public interface TrainService {
	<S extends Train> S save(S entity);

	List<Train>  save(List<Train> entitys);

	Train findOneByUuid(String uuid);

	List<Train> findAll(List<String> uuids);

	Page<Train> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	
	List<Train> findAll();
}
