package com.missiongroup.starring.modular.vhis.fault.repository;

import com.missiongroup.starring.modular.vhis.fault.domain.Fault;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.query.Procedure;

public interface FaultRepository extends JpaRepository<Fault, String>, JpaSpecificationExecutor<Fault> {

    @Procedure("faultInfo")
    void updateFaultData(String faultData);

    @Procedure("splitString")
    void updateFaultCodes(String codes, String spl);
}
