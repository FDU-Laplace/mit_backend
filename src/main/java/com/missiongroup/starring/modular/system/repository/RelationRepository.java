package com.missiongroup.starring.modular.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.missiongroup.starring.modular.system.domain.Relation;

public interface RelationRepository extends JpaRepository<Relation, String> {
	@Query(value = "select url from sys_role_menu rel inner join sys_menu m on rel.menuId = m.uuid where rel.roleId = :uuid", nativeQuery = true)
	List<String> getResUrlsByRoleId(@Param("uuid") String uuid);

	@Query("select r.menuId from Relation r where r.roleId = :roleId")
	List<String> findMenusIdsByRoleId(@Param("roleId") String roleId);

	@Modifying
	@Query("delete from Relation r where r.roleId = :roleId")
	void deleteAllByRoleId(@Param("roleId") String roleId);
}
