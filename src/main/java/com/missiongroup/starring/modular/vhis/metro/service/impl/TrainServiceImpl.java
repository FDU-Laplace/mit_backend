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

import com.missiongroup.starring.modular.vhis.metro.domain.Train;
import com.missiongroup.starring.modular.vhis.metro.repository.TrainRepository;
import com.missiongroup.starring.modular.vhis.metro.service.TrainService;

@Component("trainService")
@Transactional
public class TrainServiceImpl implements TrainService {
	
	@Autowired
	private TrainRepository TrainRepository;

	@Override
	public <S extends Train> S save(S entity) {
		return TrainRepository.save(entity);
	}
	@Override
	public List<Train>  save(List<Train> entitys) {
		List<Train> save = TrainRepository.save(entitys);
		return save;
	}
	@Override
	public Train findOneByUuid(String uuid) {
		return TrainRepository.findOne(uuid);
	}
	
	@Override
	public List<Train> findAll() {
		return TrainRepository.findAll();
	}
	@Override
	public List<Train> findAll(List<String> uuids) {
		return TrainRepository.findAll(uuids);
	}
	@Override
	public Page<Train> findAll(Pageable pageable, Map<String, Object> condition) {
		return TrainRepository.findAll(new Specification<Train>() {
			@Override
			public Predicate toPredicate(Root<Train> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("relationLine"))) {
						list.add(cb.like(root.get("relationLine").as(String.class), "%" + ((String) condition.get("relationLine")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trainId"))) {
						list.add(cb.like(root.get("trainId").as(String.class), "%" + ((String) condition.get("trainId")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trainType"))) {
						list.add(cb.like(root.get("trainType").as(String.class), "%" + ((String) condition.get("trainType")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trainName"))) {
						list.add(cb.like(root.get("trainName").as(String.class), "%" + ((String) condition.get("trainName")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("trainCode"))) {
						list.add(cb.like(root.get("trainCode").as(String.class), "%" + ((String) condition.get("trainCode")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("remark"))) {
						list.add(cb.like(root.get("remark").as(String.class), "%" + ((String) condition.get("remark")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			TrainRepository.delete(uuid);
		}
	}
}
