package com.missiongroup.starring.modular.vhis.config.service.impl;

import com.missiongroup.starring.modular.vhis.config.domain.CBConfig;
import com.missiongroup.starring.modular.vhis.config.repository.CBConfigRepository;
import com.missiongroup.starring.modular.vhis.config.service.CBConfigService;
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

@Component("CBConfigService")
@Transactional
public class CBConfigServiceImpl implements CBConfigService {
	
	@Autowired
	private CBConfigRepository CBConfigRepository;

	@Override
	public <S extends CBConfig> S save(S entity) {
		return CBConfigRepository.save(entity);
	}

	@Override
	public CBConfig findOneByUuid(String uuid) {
		return CBConfigRepository.findOne(uuid);
	}
	
	@Override
	public List<CBConfig> findAll() {
		return CBConfigRepository.findAll();
	}

	@Override
	public Page<CBConfig> findAll(Pageable pageable, Map<String, Object> condition) {
		return CBConfigRepository.findAll(new Specification<CBConfig>() {
			@Override
			public Predicate toPredicate(Root<CBConfig> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("name"))) {
						list.add(cb.like(root.get("name").as(String.class), "%" + ((String) condition.get("name")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("car"))) {
						list.add(cb.like(root.get("car").as(String.class), "%" + ((String) condition.get("car")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("description"))) {
						list.add(cb.like(root.get("description").as(String.class), "%" + ((String) condition.get("description")).replace("_", "\\_").replace("%", "\\%") + "%"));
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
			CBConfigRepository.delete(uuid);
		}
	}
}