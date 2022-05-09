package com.missiongroup.starring.modular.system.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.missiongroup.starring.modular.system.domain.User;

public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
	User findOneByAccount(String account);
	
	User findOneByName(String name);

	User findOneByEmail(String email);

	@Query("SELECT u.uuid as id, u.name as name, u.account as account, u.roleIds as roleIds FROM User u WHERE u.uuid = :uuid")
	Map<String, String> findUserInfoByUuid(@Param("uuid") String uuid);
	
	List<User> findByUuidInAndNameLike(List<String> ids,String name);
	
	List<User> findByUuidIn(List<String> ids);

	List<User> findAllByDepartId(String departId);
	
}
