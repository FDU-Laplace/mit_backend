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
import com.missiongroup.starring.modular.system.domain.LoginLog;
import com.missiongroup.starring.modular.system.repository.LoginLogRepository;
import com.missiongroup.starring.modular.system.service.LoginLogService;

@Component("loginLogService")
@Transactional
public class LoginLogServiceImpl implements LoginLogService {
	private final LoginLogRepository loginLogRepository;

	public LoginLogServiceImpl(LoginLogRepository loginLogRepository) {
		this.loginLogRepository = loginLogRepository;
	}

	@Override
	public <S extends LoginLog> S save(S entity) {
		return loginLogRepository.save(entity);
	}

	@Override
	public LoginLog findOneByUuid(String uuid) {
		return loginLogRepository.findOne(uuid);
	}

	@Override
	public Page<LoginLog> findAll(Pageable pageable, Map<String, Object> condition) {
		return loginLogRepository.findAll(new Specification<LoginLog>() {
			@Override
			public Predicate toPredicate(Root<LoginLog> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
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
			loginLogRepository.delete(uuid);
		}
	}

	@Override
	public List<LoginLog> findByUuids(String uuids) {
		List<LoginLog> loginLogs = new ArrayList<LoginLog>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			loginLogs.add(loginLogRepository.findOne(uuid));
		}
		return loginLogs;
	}

	@Override
	public String findLastLoginTime(String uuid) {
		return loginLogRepository.findUserLoginNumAndTime(uuid);
	}
}
