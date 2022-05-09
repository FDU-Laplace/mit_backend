package com.missiongroup.starring.modular.vhis.data.service.impl;

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

import com.missiongroup.starring.modular.vhis.data.domain.Iscs;
import com.missiongroup.starring.modular.vhis.data.repository.IscsRepository;
import com.missiongroup.starring.modular.vhis.data.service.IscsService;

@Component("iscsService")
@Transactional
public class IscsServiceImpl implements IscsService {
	
	@Autowired
	private IscsRepository iscsRepository;

	@Override
	public <S extends Iscs> S save(S entity) {
		return iscsRepository.save(entity);
	}

	@Override
	public Iscs findOneByUuid(String uuid) {
		return iscsRepository.findOne(uuid);
	}
	
	@Override
	public List<Iscs> findAll() {
		return iscsRepository.findAll();
	}

	@Override
	public Page<Iscs> findAll(Pageable pageable, Map<String, Object> condition) {
		return iscsRepository.findAll(new Specification<Iscs>() {
			@Override
			public Predicate toPredicate(Root<Iscs> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("trainnum"))) {
						list.add(cb.like(root.get("trainnum").as(String.class), "%" + ((String) condition.get("trainnum")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("mvbdata"))) {
						list.add(cb.like(root.get("mvbdata").as(String.class), "%" + ((String) condition.get("mvbdata")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("recordtime"))) {
						list.add(cb.like(root.get("recordtime").as(String.class), "%" + ((String) condition.get("recordtime")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			iscsRepository.delete(uuid);
		}
	}

	@Override
	public Iscs findOneByTrainnum(String trainnum) {
		return iscsRepository.findOneByTrainnum(trainnum);
	}
}
