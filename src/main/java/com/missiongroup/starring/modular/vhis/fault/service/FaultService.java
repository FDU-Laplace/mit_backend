package com.missiongroup.starring.modular.vhis.fault.service;

import java.util.LinkedList;
import java.util.Map;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.vhis.fault.domain.Fault;

public interface FaultService {
	<S extends Fault> S save(S entity);

	List saveAll(LinkedList faults);

    void updateFaultData(String faultData);

    Fault findOneByUuid(String uuid);

	Page<Fault> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);
	List<Fault> findAll();

	void confirm(String uuids);

    void updateFaultCodes(String codes);
}
