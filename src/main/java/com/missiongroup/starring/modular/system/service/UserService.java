package com.missiongroup.starring.modular.system.service;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.User;

public interface UserService {
	<S extends User> S save(S entity);

	User findOneByUuid(String uuid);

	User findOneByAccount(String account);

	User findOneByEmail(String email);

	Page<User> findAll(Pageable pageable, Map<String, Object> condition);

	void delete(String uuids);

	void resetPassword(String uuids);

	void updatePassword(String uuid, String password);

	void freeze(String uuids);

	void unfreeze(String uuids);

	void updateRoles(String uuids, String roleIds);

	Map<String, String> findUserInfoByUuid(String uuid);

	List<User> findAll();
	
	List<User> findByUuidIn(List<String> ids);
	
	List<User> findByUuidInAndNameLike(List<String> ids, String name);
	
}
