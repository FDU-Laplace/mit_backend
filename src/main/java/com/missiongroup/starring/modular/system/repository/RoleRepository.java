package com.missiongroup.starring.modular.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.missiongroup.starring.modular.system.domain.Role;

public interface RoleRepository extends JpaRepository<Role, String>, JpaSpecificationExecutor<Role> {
	Role findOneByName(String name);

	@Query("select max(r.sort) from Role r")
	Integer findMaxSort();

	@Query("from Role r order by r.updateTime desc")
	List<Role> findAllOrderByUpdateTime();

	List<Role> findAllByDepartId(String departId);
}
