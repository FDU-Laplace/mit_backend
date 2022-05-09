package com.missiongroup.starring.modular.vhis.pushDate.service.impl;

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

import com.missiongroup.starring.modular.vhis.pushDate.domain.CarriageData;
import com.missiongroup.starring.modular.vhis.pushDate.repository.CarriageDataRepository;
import com.missiongroup.starring.modular.vhis.pushDate.service.CarriageDataService;

@Component("CarriageDataService")
@Transactional
public class CarriageDataServiceImpl implements CarriageDataService {
	
	@Autowired
	private CarriageDataRepository CarriageDataRepository;

	@Override
	public <S extends CarriageData> S save(S entity) {
		return CarriageDataRepository.save(entity);
	}

	@Override
	public CarriageData findOneByUuid(String uuid) {
		return CarriageDataRepository.findOne(uuid);
	}
	
	@Override
	public List<CarriageData> findAll() {
		return CarriageDataRepository.findAll();
	}

	@Override
	public Page<CarriageData> findAll(Pageable pageable, Map<String, Object> condition) {
		return CarriageDataRepository.findAll(new Specification<CarriageData>() {
			@Override
			public Predicate toPredicate(Root<CarriageData> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("ts_timestamp"))) {
						list.add(cb.like(root.get("ts_timestamp").as(String.class), "%" + ((String) condition.get("ts_timestamp")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageId"))) {
						list.add(cb.like(root.get("carriageId").as(String.class), "%" + ((String) condition.get("carriageId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("carriageNum"))) {
						list.add(cb.like(root.get("carriageNum").as(String.class), "%" + ((String) condition.get("carriageNum")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trianId"))) {
						list.add(cb.like(root.get("trianId").as(String.class), "%" + ((String) condition.get("trianId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineId"))) {
						list.add(cb.like(root.get("lineId").as(String.class), "%" + ((String) condition.get("lineId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("dricab_activate"))) {
						list.add(cb.like(root.get("dricab_activate").as(String.class), "%" + ((String) condition.get("dricab_activate")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("dricab_wall_door"))) {
						list.add(cb.like(root.get("dricab_wall_door").as(String.class), "%" + ((String) condition.get("dricab_wall_door")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("dricab_escape_door"))) {
						list.add(cb.like(root.get("dricab_escape_door").as(String.class), "%" + ((String) condition.get("dricab_escape_door")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("riding_rate"))) {
						list.add(cb.like(root.get("riding_rate").as(String.class), "%" + ((String) condition.get("riding_rate")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("brake_state"))) {
						list.add(cb.like(root.get("brake_state").as(String.class), "%" + ((String) condition.get("brake_state")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("compartment_temperature"))) {
						list.add(cb.like(root.get("compartment_temperature").as(String.class), "%" + ((String) condition.get("compartment_temperature")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("humidity"))) {
						list.add(cb.like(root.get("humidity").as(String.class), "%" + ((String) condition.get("humidity")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("traction"))) {
						list.add(cb.like(root.get("traction").as(String.class), "%" + ((String) condition.get("traction")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			CarriageDataRepository.delete(uuid);
		}
	}
}
