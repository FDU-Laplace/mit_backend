package com.missiongroup.starring.modular.vhis.pushDate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.missiongroup.starring.modular.vhis.pushDate.domain.CarriageData;

public interface CarriageDataRepository extends JpaRepository<CarriageData, String>, JpaSpecificationExecutor<CarriageData> {

}
