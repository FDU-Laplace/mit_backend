package com.missiongroup.starring.modular.vhis.fault.repository;

import com.missiongroup.starring.modular.vhis.fault.domain.FaultHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/1
 */
public interface FaultHistoryRepository extends JpaRepository<FaultHistory, String>, JpaSpecificationExecutor<FaultHistory> {

}
