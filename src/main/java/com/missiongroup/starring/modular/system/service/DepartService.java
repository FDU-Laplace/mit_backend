package com.missiongroup.starring.modular.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.Depart;

public interface DepartService {
	<S extends Depart> S save(S entity);

	Depart findOneByUuid(String uuid);

	Depart findOneByName(String name);

	List<Depart> findByUuids(String uuids);

	List<Depart> findByParentIdsLike(String parentIds);

	void delete(String uuids);

	Page<Depart> findAll(Pageable pageable);

	List<Depart> findAll();

	Integer findMaxSort(String parentId);

	String findParentIdsByUuid(String uuid);
}
