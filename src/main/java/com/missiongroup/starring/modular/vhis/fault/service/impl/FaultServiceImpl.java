package com.missiongroup.starring.modular.vhis.fault.service.impl;

import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.modular.vhis.fault.domain.Fault;
import com.missiongroup.starring.modular.vhis.fault.repository.FaultRepository;
import com.missiongroup.starring.modular.vhis.fault.service.FaultService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.*;

@Component("FaultService")
@Transactional
public class FaultServiceImpl implements FaultService {

    @Autowired
    private FaultRepository FaultRepository;

    @Override
    public <S extends Fault> S save(S entity) {
        return FaultRepository.save(entity);
    }

    @Override
    public List saveAll(LinkedList faults) {
        return FaultRepository.save(faults);
    }

    @Override
    public void updateFaultData(String faultData) {
        FaultRepository.updateFaultData(faultData);
    }

    @Override
    public Fault findOneByUuid(String uuid) {
        return FaultRepository.findOne(uuid);
    }

    @Override
    public List<Fault> findAll() {
        return FaultRepository.findAll();
    }

    @Override
    public Page<Fault> findAll(Pageable pageable, Map<String, Object> condition) {
        return FaultRepository.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();

            if (null != condition) {
                if (StringUtils.isNotBlank((String) condition.get("relationLin"))) {
                    list.add(cb.like(root.get("relationLin").as(String.class), "%" + ((String) condition.get("relationLin")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("relationTrain"))) {
                    String[] relationTrains = ((String) condition.get("relationTrain")).split(",");
                    list.add(root.get("relationTrain").as(String.class).in((Object[]) relationTrains));
                }
                if (StringUtils.isNotBlank((String) condition.get("relationCarriage"))) {
                    list.add(cb.like(root.get("relationCarriage").as(String.class), "%" + ((String) condition.get("relationCarriage")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("faultSys"))) {
                    list.add(cb.like(root.get("faultSys").as(String.class), "%" + ((String) condition.get("faultSys")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("faultCode"))) {
                    list.add(cb.like(root.get("faultCode").as(String.class), "%" + ((String) condition.get("faultCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("faultName"))) {
                    list.add(cb.like(root.get("faultName").as(String.class), "%" + ((String) condition.get("faultName")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("faultLevel"))) {
                    String[] faultLevels = ((String) condition.get("faultLevel")).split(",");
                    list.add(root.get("faultLevel").as(String.class).in((Object[]) faultLevels));
                }
                if (StringUtils.isNotBlank((String) condition.get("isFault"))) {
                    list.add(cb.like(root.get("isFault").as(String.class), "%" + ((String) condition.get("isFault")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }

                if (StringUtils.isNotBlank((String) condition.get("currentStation"))) {
                    list.add(cb.like(root.get("currentStation").as(String.class), "%" + ((String) condition.get("currentStation")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("nextStation"))) {
                    list.add(cb.like(root.get("nextStation").as(String.class), "%" + ((String) condition.get("nextStation")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("trainPosition"))) {
                    list.add(cb.like(root.get("trainPosition").as(String.class), "%" + ((String) condition.get("trainPosition")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("confirmFault"))) {
                    list.add(cb.like(root.get("confirmFault").as(String.class), "%" + ((String) condition.get("confirmFault")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("confirmTime"))) {
                    list.add(cb.like(root.get("confirmTime").as(String.class), "%" + ((String) condition.get("confirmTime")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("remarks"))) {
                    list.add(cb.like(root.get("remarks").as(String.class), "%" + ((String) condition.get("remarks")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("beginTime"))) {
                    list.add(cb.greaterThanOrEqualTo(root.get("updateTime").as(String.class), condition.get("beginTime") + " 00:00:00"));
                }
                if (StringUtils.isNotBlank((String) condition.get("endTime"))) {
                    list.add(cb.lessThanOrEqualTo(root.get("updateTime").as(String.class), condition.get("endTime") + " 23:59:59"));
                }
                if (StringUtils.isNotBlank((String) condition.get("occurrenceTimeBegin"))) {
                    list.add(cb.greaterThanOrEqualTo(root.get("occurrenceTime").as(String.class), condition.get("occurrenceTimebegin") + " 00:00:00"));
                }
                if (StringUtils.isNotBlank((String) condition.get("occurrenceTimeEnd"))) {
                    list.add(cb.lessThanOrEqualTo(root.get("occurrenceTime").as(String.class), condition.get("occurrenceTimeEnd") + " 23:59:59"));
                }
                if (StringUtils.isNotBlank((String) condition.get("durationBegin"))) {
                    list.add(cb.greaterThanOrEqualTo(root.get("duration").as(String.class), condition.get("durationbegin") + " 00:00:00"));
                }
                if (StringUtils.isNotBlank((String) condition.get("durationEnd"))) {
                    list.add(cb.lessThanOrEqualTo(root.get("duration").as(String.class), condition.get("durationEnd") + " 23:59:59"));
                }
            }
            Predicate[] pre = new Predicate[list.size()];
            return query.where(list.toArray(pre)).getRestriction();
        }, pageable);
    }

    @Override
    public void delete(String uuids) {
        String[] ids = uuids.split(",");
        for (String uuid : ids) {
            FaultRepository.delete(uuid);
        }
    }

    @Override
    public void confirm(String uuids) {
        String[] ids = uuids.split(",");
        for (String uuid : ids) {
            Fault fault = FaultRepository.findOne(uuid);
            fault.setConfirmFault("1");
            Date date = new Date();
            fault.setConfirmTime(date);
            fault.setUpdateUserId(ShiroKit.getUser().getId());
            fault.setUpdateTime(date);
            FaultRepository.save(fault);
        }
    }

    @Override
    public void updateFaultCodes(String codes) {
        FaultRepository.updateFaultCodes(codes, ",");
    }
}
