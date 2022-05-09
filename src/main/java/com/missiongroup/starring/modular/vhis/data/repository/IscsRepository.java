package com.missiongroup.starring.modular.vhis.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.missiongroup.starring.modular.vhis.data.domain.Iscs;

public interface IscsRepository extends JpaRepository<Iscs, String>, JpaSpecificationExecutor<Iscs> {
	
	Iscs findOneByTrainnum(String trainnum);
}
