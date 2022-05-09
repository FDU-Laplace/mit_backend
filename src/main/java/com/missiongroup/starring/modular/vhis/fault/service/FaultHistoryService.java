package com.missiongroup.starring.modular.vhis.fault.service;

import com.missiongroup.starring.modular.vhis.fault.domain.FaultHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public interface FaultHistoryService {
    <S extends FaultHistory> S save(S entity);

    List saveAll(LinkedList faultHistorys);

    void updateFaultHistoryData(String faultHistoryData);

    FaultHistory findOneByUuid(String uuid);

    Page<FaultHistory> findAll(Pageable pageable, Map<String, Object> condition);

    void delete(String uuids);

    List<FaultHistory> findAll();

    void confirm(String uuids);
}
