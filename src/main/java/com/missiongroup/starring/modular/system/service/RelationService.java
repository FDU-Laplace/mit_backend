package com.missiongroup.starring.modular.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.Relation;

public interface RelationService {
	<S extends Relation> S save(S entity);

	Relation findOneByUuid(String uuid);

	List<Relation> findByUuids(String uuids);

	void delete(String uuids);

	Page<Relation> findAll(Pageable pageable);

	List<String> getResUrlsByRoleId(String uuid);

	List<String> findMenusIdsByRoleId(String roleId);

	void deleteAllByRoleId(String roleId);
}
