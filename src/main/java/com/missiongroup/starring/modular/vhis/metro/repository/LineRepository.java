package com.missiongroup.starring.modular.vhis.metro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.missiongroup.starring.modular.vhis.metro.domain.Line;

public interface LineRepository extends JpaRepository<Line, String>, JpaSpecificationExecutor<Line> {

}
