package com.missiongroup.starring.modular.vhis.fault.service.impl;

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.modular.vhis.config.domain.FaultConfig;
import com.missiongroup.starring.modular.vhis.config.repository.FaultConfigRepository;
import com.missiongroup.starring.modular.vhis.fault.domain.LevelConfig;
import com.missiongroup.starring.modular.vhis.fault.domain.dto.FaultDto;
import com.missiongroup.starring.modular.vhis.fault.repository.LevelConfigRepository;
import com.missiongroup.starring.modular.vhis.fault.service.LevelConfigService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zzbin
 * @Date: Create in 2021/1/1
 */

@Component("LevelConfigService")
@Transactional
public class LevelConfigServiceImpl implements LevelConfigService {

    @Autowired
    private LevelConfigRepository levelConfigRepository;

    @Autowired
    private ICache iCaches;

    @Autowired
    private FaultConfigRepository faultConfigRepository;

    @Override
    public <S extends LevelConfig> S save(S entity) {
        S save = levelConfigRepository.save(entity);
        List<FaultConfig> faultConfigs = faultConfigRepository.findAll();
        iCaches.put("CONSTANT", "faultConfigs", faultConfigs);
        return save;
    }

    @Override
    public List saveAll(LinkedList faultHistorys) {
        return levelConfigRepository.save(faultHistorys);
    }

    @Override
    public void updatelevelConfData(String levelConf) {

    }


    @Override
    public LevelConfig findOneByUuid(String uuid) {
        return levelConfigRepository.findOne(uuid);
    }

    @Override
    public Page<LevelConfig> findAll(Pageable pageable, Map<String, Object> condition) {
        return levelConfigRepository.findAll((root, query, cb) -> {
            List<Predicate> list = new ArrayList<>();

            if (null != condition) {
                if (StringUtils.isNotBlank((String) condition.get("color"))) {
                    list.add(cb.like(root.get("color").as(String.class), "%" + ((String) condition.get("color")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("faultLevel"))) {
                    list.add(cb.like(root.get("faultLevel").as(String.class), "%" + ((String) condition.get("faultLevel")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("levelName"))) {
                    list.add(cb.like(root.get("levelName").as(String.class), "%" + ((String) condition.get("levelName")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("voice"))) {
                    list.add(cb.like(root.get("voice").as(String.class), "%" + ((String) condition.get("voice")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }
                if (StringUtils.isNotBlank((String) condition.get("twinkle"))) {
                    list.add(cb.like(root.get("twinkle").as(String.class), "%" + ((String) condition.get("twinkle")).replace("_", "\\_").replace("%", "\\%") + "%"));
                }

                if (StringUtils.isNotBlank((String) condition.get("beginTime"))) {
                    list.add(cb.greaterThanOrEqualTo(root.get("updateTime").as(String.class), condition.get("beginTime") + " 00:00:00"));
                }
                if (StringUtils.isNotBlank((String) condition.get("endTime"))) {
                    list.add(cb.lessThanOrEqualTo(root.get("updateTime").as(String.class), condition.get("endTime") + " 23:59:59"));
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
            List<FaultConfig> faultConfigs = faultConfigRepository.findByLevelConfigId(uuid);
            if (!faultConfigs.isEmpty()) {
                throw new BussinessException(BizExceptionEnum.ASSOCIATED_FAULT_CONFIGURATION_EXISTS);
            }
            levelConfigRepository.delete(uuid);
        }
    }

    @Override
    public List<LevelConfig> findAll() {
        return levelConfigRepository.findAll();
    }

    @Override
    public void confirm(String uuids) {
        String[] ids = uuids.split(",");
    }

    @Override
    public List<LevelConfig> findByFaultLevel(String level) {
        return levelConfigRepository.findByFaultLevel(level);
    }

    @Override
    public List<LevelConfig> findByIcon(String icon) {
        return levelConfigRepository.findByIcon(icon);
    }

    @Override
    public List<FaultDto> findLevelConfigJoinFault(List<FaultDto> dto) {
        List<LevelConfig> all = levelConfigRepository.findAll();
        dto.stream().forEach(d -> {
            for (LevelConfig a : all) {
                if (a.getFaultLevel().equals(d.getFaultLevel())) {
                    d.setColor(a.getColor());
                    d.setVoice(a.getVoice());
                    d.setMinor(a.getMinor());
                    d.setTwinkle(a.getTwinkle());
                    d.setLevelName(a.getLevelName());
                    d.setIcon(a.getIcon());
                    d.setBackgroundColor(a.getBackgroundColor());
                }
            }
        });
        return dto;
    }
}
