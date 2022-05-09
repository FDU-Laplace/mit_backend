package com.missiongroup.starring.modular.vhis.metro.service.impl;

import com.missiongroup.starring.modular.vhis.metro.domain.ConfigInfo;
import com.missiongroup.starring.modular.vhis.metro.repository.ConfigInfoRepository;
import com.missiongroup.starring.modular.vhis.metro.service.ConfigInfoService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component("ConfigInfoService")
@Transactional
public class ConfigInfoServiceImpl implements ConfigInfoService {

    @Autowired
    private ConfigInfoRepository configInfoRepository;

    @Override
    public <S extends ConfigInfo> S save(S entity) {
        return configInfoRepository.save(entity);
    }

    @Override
    public ConfigInfo findOneByUuid(String uuid) {
        return configInfoRepository.findOne(uuid);
    }

    @Override
    public Page<ConfigInfo> findAll(Pageable pageable, Map<String, Object> condition) {
        return configInfoRepository.findAll(new Specification<ConfigInfo>() {
            @Override
            public Predicate toPredicate(Root<ConfigInfo> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> list = new ArrayList<>();

                if (null != condition) {
                    if (StringUtils.isNotBlank((String) condition.get("name"))) {
                        list.add(cb.like(root.get("name").as(String.class), "%" + ((String) condition.get("name")).replace("_", "\\_").replace("%", "\\%") + "%"));
                    }
                    if (StringUtils.isNotBlank((String) condition.get("number"))) {
                        list.add(cb.like(root.get("number").as(String.class), "%" + ((String) condition.get("number")).replace("_", "\\_").replace("%", "\\%") + "%"));
                    }
                    if (StringUtils.isNotBlank((String) condition.get("port"))) {
                        list.add(cb.like(root.get("port").as(String.class), "%" + ((String) condition.get("port")).replace("_", "\\_").replace("%", "\\%") + "%"));
                    }
                    if (StringUtils.isNotBlank((String) condition.get("field"))) {
                        list.add(cb.like(root.get("field").as(String.class), "%" + ((String) condition.get("field")).replace("_", "\\_").replace("%", "\\%") + "%"));
                    }
                    if (StringUtils.isNotBlank((String) condition.get("comment"))) {
                        list.add(cb.like(root.get("comment").as(String.class), "%" + ((String) condition.get("comment")).replace("_", "\\_").replace("%", "\\%") + "%"));
                    }

                    if (StringUtils.isNotBlank((String) condition.get("beginTime"))) {
                        list.add(cb.greaterThanOrEqualTo(root.get("updateTime").as(String.class), (String) condition.get("beginTime") + " 00:00:00"));
                    }
                    if (StringUtils.isNotBlank((String) condition.get("endTime"))) {
                        list.add(cb.lessThanOrEqualTo(root.get("updateTime").as(String.class), (String) condition.get("endTime") + " 23:59:59"));
                    }
                }
                Predicate[] pre = new Predicate[list.size()];
                return query.where(list.toArray(pre)).getRestriction();
            }
        }, pageable);
    }

    @Override
    public void delete(String uuids) {
        String[] ids = uuids.split(",");
        for (String uuid : ids) {
            configInfoRepository.delete(uuid);
        }
    }

    @Override
    public List<ConfigInfo> findAll() {
        return configInfoRepository.findAll();
    }
}
