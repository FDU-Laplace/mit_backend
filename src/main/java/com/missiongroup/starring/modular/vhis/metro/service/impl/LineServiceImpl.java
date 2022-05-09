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

import com.missiongroup.starring.core.cache.ICache;
import com.missiongroup.starring.modular.vhis.metro.domain.Line;
import com.missiongroup.starring.modular.vhis.metro.repository.LineRepository;
import com.missiongroup.starring.modular.vhis.metro.service.LineService;

@Component("LineService")
@Transactional
public class LineServiceImpl implements LineService {
	
	@Autowired
	ICache iCaches;
	
	@Autowired
	private LineRepository LineRepository;

	@Override
	public <S extends Line> S save(S entity) {
		return LineRepository.save(entity);
	}

	@Override
	public Line findOneByUuid(String uuid) {
		return LineRepository.findOne(uuid);
	}
	
	@Override
	public List<Line> findAll() {
		return LineRepository.findAll();
	}

	@Override
	public Page<Line> findAll(Pageable pageable, Map<String, Object> condition) {
		return LineRepository.findAll(new Specification<Line>() {
			@Override
			public Predicate toPredicate(Root<Line> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("lineId"))) {
						list.add(cb.like(root.get("lineId").as(String.class), "%" + ((String) condition.get("lineId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineType"))) {
						list.add(cb.like(root.get("lineType").as(String.class), "%" + ((String) condition.get("lineType")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineColor"))) {
						list.add(cb.like(root.get("lineColor").as(String.class), "%" + ((String) condition.get("lineColor")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineName"))) {
						list.add(cb.like(root.get("lineName").as(String.class), "%" + ((String) condition.get("lineName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("company"))) {
						list.add(cb.like(root.get("company").as(String.class), "%" + ((String) condition.get("company")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineNameEn"))) {
						list.add(cb.like(root.get("lineNameEn").as(String.class), "%" + ((String) condition.get("lineNameEn")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineNum"))) {
						list.add(cb.like(root.get("lineNum").as(String.class), "%" + ((String) condition.get("lineNum")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("lineCode"))) {
						list.add(cb.like(root.get("lineCode").as(String.class), "%" + ((String) condition.get("lineCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("isRun"))) {
						list.add(cb.like(root.get("isRun").as(String.class), "%" + ((String) condition.get("isRun")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			LineRepository.delete(uuid);
		}
	}
}
