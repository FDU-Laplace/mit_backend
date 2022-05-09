package com.missiongroup.starring.modular.vhis.metro.service.impl;

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

import com.missiongroup.starring.modular.vhis.metro.domain.Carriage;
import com.missiongroup.starring.modular.vhis.metro.repository.CarriageRepository;
import com.missiongroup.starring.modular.vhis.metro.service.CarriageService;

@Component("CarriageService")
@Transactional
public class CarriageServiceImpl implements CarriageService {
	
	@Autowired
	private CarriageRepository CarriageRepository;

	@Override
	public <S extends Carriage> S save(S entity) {
		return CarriageRepository.save(entity);
	}

	@Override
	public Carriage findOneByUuid(String uuid) {
		return CarriageRepository.findOne(uuid);
	}
	
	@Override
	public List<Carriage> findAll() {
		return CarriageRepository.findAll();
	}

	@Override
	public Page<Carriage> findAll(Pageable pageable, Map<String, Object> condition) {
		return CarriageRepository.findAll(new Specification<Carriage>() {
			@Override
			public Predicate toPredicate(Root<Carriage> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("relationLine"))) {
						list.add(cb.like(root.get("relationLine").as(String.class), "%" + ((String) condition.get("relationLine")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("relationTrain"))) {
						list.add(cb.like(root.get("relationTrain").as(String.class), "%" + ((String) condition.get("relationTrain")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageId"))) {
						list.add(cb.like(root.get("carriageId").as(String.class), "%" + ((String) condition.get("carriageId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageType"))) {
						list.add(cb.like(root.get("carriageType").as(String.class), "%" + ((String) condition.get("carriageType")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageName"))) {
						list.add(cb.like(root.get("carriageName").as(String.class), "%" + ((String) condition.get("carriageName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageCode"))) {
						list.add(cb.like(root.get("carriageCode").as(String.class), "%" + ((String) condition.get("carriageCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			CarriageRepository.delete(uuid);
		}
	}
}
