package com.missiongroup.starring.modular.vhis.alert.service.impl;

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

import com.missiongroup.starring.modular.vhis.alert.domain.AlertRule;
import com.missiongroup.starring.modular.vhis.alert.repository.AlertRuleRepository;
import com.missiongroup.starring.modular.vhis.alert.service.AlertRuleService;

@Component("AlertRuleService")
@Transactional
public class AlertRuleServiceImpl implements AlertRuleService {
	
	@Autowired
	private AlertRuleRepository AlertRuleRepository;

	@Override
	public <S extends AlertRule> S save(S entity) {
		return AlertRuleRepository.save(entity);
	}

	@Override
	public AlertRule findOneByUuid(String uuid) {
		return AlertRuleRepository.findOne(uuid);
	}
	
	@Override
	public List<AlertRule> findAll() {
		return AlertRuleRepository.findAll();
	}

	@Override
	public Page<AlertRule> findAll(Pageable pageable, Map<String, Object> condition) {
		return AlertRuleRepository.findAll(new Specification<AlertRule>() {
			@Override
			public Predicate toPredicate(Root<AlertRule> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("ruleCode"))) {
						list.add(cb.like(root.get("ruleCode").as(String.class), "%" + ((String) condition.get("ruleCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("ruleName"))) {
						list.add(cb.like(root.get("ruleName").as(String.class), "%" + ((String) condition.get("ruleName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("ruleValue"))) {
						list.add(cb.like(root.get("ruleValue").as(String.class), "%" + ((String) condition.get("ruleValue")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			AlertRuleRepository.delete(uuid);
		}
	}
}
