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

import com.missiongroup.starring.modular.vhis.metro.domain.Station;
import com.missiongroup.starring.modular.vhis.metro.repository.StationRepository;
import com.missiongroup.starring.modular.vhis.metro.service.StationService;

@Component("StationService")
@Transactional
public class StationServiceImpl implements StationService {
	
	@Autowired
	private StationRepository StationRepository;

	@Override
	public <S extends Station> S save(S entity) {
		return StationRepository.save(entity);
	}

	@Override
	public Station findOneByUuid(String uuid) {
		return StationRepository.findOne(uuid);
	}
	
	@Override
	public List<Station> findAll() {
		return StationRepository.findAll();
	}

	@Override
	public Page<Station> findAll(Pageable pageable, Map<String, Object> condition) {
		return StationRepository.findAll(new Specification<Station>() {
			@Override
			public Predicate toPredicate(Root<Station> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("stationId"))) {
						list.add(cb.like(root.get("stationId").as(String.class), "%" + ((String) condition.get("stationId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("stationName"))) {
						list.add(cb.like(root.get("stationName").as(String.class), "%" + ((String) condition.get("stationName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("stationNameEn"))) {
						list.add(cb.like(root.get("stationNameEn").as(String.class), "%" + ((String) condition.get("stationNameEn")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("stationNameSpell"))) {
						list.add(cb.like(root.get("stationNameSpell").as(String.class), "%" + ((String) condition.get("stationNameSpell")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			StationRepository.delete(uuid);
		}
	}
}
