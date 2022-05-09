package com.missiongroup.starring.modular.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.missiongroup.starring.modular.system.domain.Depart;

public interface DepartRepository extends JpaRepository<Depart, String>, JpaSpecificationExecutor<Depart> {
	List<Depart> findByParentIdsLike(String parentIds);

	Depart findOneByName(String name);

	@Query("select max(d.sort) from Depart d where d.parentId = :parentId")
	Integer findMaxSort(@Param("parentId") String parentId);

	@Query("select d.parentIds from Depart d where d.uuid = :uuid")
	String findParentIdsByUuid(@Param("uuid") String uuid);
}
