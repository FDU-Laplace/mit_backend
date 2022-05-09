package com.missiongroup.starring.modular.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.common.constant.Const;
import com.missiongroup.starring.modular.system.domain.OperationLog;
import com.missiongroup.starring.modular.system.repository.OperationLogRepository;
import com.missiongroup.starring.modular.system.service.OperationLogService;

@Component("operationLogService")
@Transactional
public class OperationLogServiceImpl implements OperationLogService {
	private final OperationLogRepository operationLogRepository;

	public OperationLogServiceImpl(OperationLogRepository operationLogRepository) {
		this.operationLogRepository = operationLogRepository;
	}

	@Override
	public <S extends OperationLog> S save(S entity) {
		return operationLogRepository.save(entity);
	}

	@Override
	public OperationLog findOneByUuid(String uuid) {
		return operationLogRepository.findOne(uuid);
	}

	@Override
	public Page<OperationLog> findAll(Pageable pageable, Map<String, Object> condition) {
		return operationLogRepository.findAll(new Specification<OperationLog>() {
			@Override
			public Predicate toPredicate(Root<OperationLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != condition) {
					List<Predicate> list = new ArrayList<Predicate>();
					
					list.add(cb.notEqual(root.get("userId").as(String.class), Const.ADMIN_ID));

					if (StringUtils.isNotBlank((String) condition.get("beginTime"))) {
						list.add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class), (String) condition.get("beginTime") + " 00:00:00"));
					}
					if (StringUtils.isNotBlank((String) condition.get("endTime"))) {
						list.add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), (String) condition.get("endTime") + " 23:59:59"));
					}
					if (null != condition.get("type") && (Integer) condition.get("type") != -1) {
						list.add(cb.equal(root.get("type").as(Integer.class), (Integer) condition.get("type")));
					}
					if (StringUtils.isNotBlank((String) condition.get("name"))) {
						list.add(cb.like(root.get("name").as(String.class), "%" + ((String) condition.get("name")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					Predicate[] pre = new Predicate[list.size()];
					return query.where(list.toArray(pre)).getRestriction();
				}
				return null;
			}
		}, pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			operationLogRepository.delete(uuid);
		}
	}

	@Override
	public List<OperationLog> findByUuids(String uuids) {
		List<OperationLog> operationLogs = new ArrayList<OperationLog>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			operationLogs.add(operationLogRepository.findOne(uuid));
		}
		return operationLogs;
	}
}
