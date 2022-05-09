package com.missiongroup.starring.modular.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.missiongroup.starring.modular.system.domain.LoginLog;

public interface LoginLogRepository extends JpaRepository<LoginLog, String>, JpaSpecificationExecutor<LoginLog> {
	@Query(value = "select max(createTime) as lastLoginTime from sys_login_log where 1=1 and type = 0 and userId = :userId and createTime < (select max(createTime) createTime from sys_login_log where 1=1 and type = 0 and userId = :userId )", nativeQuery = true)
	String findUserLoginNumAndTime(@Param("userId") String uuid);
}
