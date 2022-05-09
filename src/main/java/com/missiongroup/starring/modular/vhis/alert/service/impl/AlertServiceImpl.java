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

import com.missiongroup.starring.modular.vhis.alert.domain.Alert;
import com.missiongroup.starring.modular.vhis.alert.repository.AlertRepository;
import com.missiongroup.starring.modular.vhis.alert.service.AlertService;

@Component("AlertService")
@Transactional
public class AlertServiceImpl implements AlertService {
	
	@Autowired
	private AlertRepository AlertRepository;

	@Override
	public <S extends Alert> S save(S entity) {
		return AlertRepository.save(entity);
	}

	@Override
	public Alert findOneByUuid(String uuid) {
		return AlertRepository.findOne(uuid);
	}
	
	@Override
	public List<Alert> findAll() {
		return AlertRepository.findAll();
	}

	@Override
	public Page<Alert> findAll(Pageable pageable, Map<String, Object> condition) {
		return AlertRepository.findAll(new Specification<Alert>() {
			@Override
			public Predicate toPredicate(Root<Alert> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("alertCode"))) {
						list.add(cb.like(root.get("alertCode").as(String.class), "%" + ((String) condition.get("alertCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("relationLin"))) {
						list.add(cb.like(root.get("relationLin").as(String.class), "%" + ((String) condition.get("relationLin")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("relationTrain"))) {
						list.add(cb.like(root.get("relationTrain").as(String.class), "%" + ((String) condition.get("relationTrain")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("alertSys"))) {
						list.add(cb.like(root.get("alertSys").as(String.class), "%" + ((String) condition.get("alertSys")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("relationRule"))) {
						list.add(cb.like(root.get("relationRule").as(String.class), "%" + ((String) condition.get("relationRule")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("alertName"))) {
						list.add(cb.like(root.get("alertName").as(String.class), "%" + ((String) condition.get("alertName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("alertLevel"))) {
						list.add(cb.like(root.get("alertLevel").as(String.class), "%" + ((String) condition.get("alertLevel")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("isAlert"))) {
						list.add(cb.like(root.get("isAlert").as(String.class), "%" + ((String) condition.get("isAlert")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("pushStatus"))) {
						list.add(cb.like(root.get("pushStatus").as(String.class), "%" + ((String) condition.get("pushStatus")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("alertTime"))) {
						list.add(cb.like(root.get("alertTime").as(String.class), "%" + ((String) condition.get("alertTime")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("remarks"))) {
						list.add(cb.like(root.get("remarks").as(String.class), "%" + ((String) condition.get("remarks")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			AlertRepository.delete(uuid);
		}
	}
}
