package com.missiongroup.starring.modular.vhis.config.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.modular.vhis.config.domain.Config;
import com.missiongroup.starring.modular.vhis.config.repository.ConfigRepository;
import com.missiongroup.starring.modular.vhis.config.service.ConfigService;

@Component("ConfigService")
@Transactional
public class ConfigServiceImpl implements ConfigService {
	
	@Autowired
	private ConfigRepository ConfigRepository;

	@Override
	public <S extends Config> S save(S entity) {
		return ConfigRepository.save(entity);
	}

	@Override
	public Config findOneByUuid(String uuid) {
		return ConfigRepository.findOne(uuid);
	}
	
	@Override
	public List<Config> findAll() {
		return ConfigRepository.findAll();
	}

	@Override
	public Page<Config> findAll(Pageable pageable, Map<String, Object> condition) {
		return ConfigRepository.findAll(new Specification<Config>() {
			@Override
			public Predicate toPredicate(Root<Config> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("configCode"))) {
						list.add(cb.like(root.get("configCode").as(String.class), "%" + ((String) condition.get("configCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("configValue"))) {
						list.add(cb.like(root.get("configValue").as(String.class), "%" + ((String) condition.get("configValue")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("remark"))) {
						list.add(cb.like(root.get("remark").as(String.class), "%" + ((String) condition.get("remark")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("isCache"))) {
						list.add(cb.like(root.get("isCache").as(String.class), "%" + ((String) condition.get("isCache")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			ConfigRepository.delete(uuid);
		}
	}
}
