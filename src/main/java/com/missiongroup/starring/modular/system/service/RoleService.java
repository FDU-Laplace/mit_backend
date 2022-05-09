package com.missiongroup.starring.modular.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.Role;

public interface RoleService {
	<S extends Role> S save(S entity);

	Role findOneByUuid(String uuid);

	Role findOneByName(String name);

	List<Role> findByUuids(String uuids);

	void delete(String uuids);

	Page<Role> findAll(Pageable pageable, Map<String, Object> condition);

	List<Role> findAll();

	Integer findMaxSort();

	void updateAuthority(String roleId, String ids);
}
