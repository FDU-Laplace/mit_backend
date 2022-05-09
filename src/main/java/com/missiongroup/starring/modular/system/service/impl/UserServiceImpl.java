package com.missiongroup.starring.modular.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
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
import com.missiongroup.starring.common.constant.state.ManagerStatus;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.repository.UserRepository;
import com.missiongroup.starring.modular.system.service.UserService;

@Component("userService")
@Transactional
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public <S extends User> S save(S entity) {
		return userRepository.save(entity);
	}

	@Override
	public User findOneByUuid(String uuid) {
		return userRepository.findOne(uuid);
	}

	@Override
	public Page<User> findAll(Pageable pageable, Map<String, Object> condition) {
		return userRepository.findAll(new Specification<User>() {
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				list.add(cb.notEqual(root.get("uuid").as(String.class), "00000000000000000000000000000001"));
				if (null != condition) {
					if (StringUtils.isNotBlank((String) condition.get("account"))) {
						list.add(cb.like(root.get("account").as(String.class), "%" + ((String) condition.get("account")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("roleIds"))) {
						list.add(cb.like(root.get("roleIds").as(String.class), "%" + (String) condition.get("roleIds") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("name"))) {
						list.add(cb.like(root.get("name").as(String.class), "%" + ((String) condition.get("name")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("phone"))) {
						list.add(cb.like(root.get("phone").as(String.class), "%" + ((String) condition.get("phone")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("departId"))) {
						list.add(cb.like(root.get("departIdPath").as(String.class), "%" + (String) condition.get("departId") + "%"));
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
	public User findOneByAccount(String account) {
		return userRepository.findOneByAccount(account);
	}

	@Override
	public User findOneByEmail(String email) {
		return userRepository.findOneByEmail(email);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			userRepository.delete(uuid);
		}
	}

	@Override
	public void resetPassword(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			User user = userRepository.findOne(uuid);
			user.setSalt(ShiroKit.getRandomSalt(5));
			user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
			user.setUpdateTime(new Date());
			user.setUpdateUserId(ShiroKit.getUser().getId());
			userRepository.save(user);
		}
	}

    @Override
    public void updatePassword(String uuid, String password) {
		User user = userRepository.findOne(uuid);
		user.setSalt(ShiroKit.getRandomSalt(5));
		user.setPassword(ShiroKit.md5(password, user.getSalt()));
		user.setUpdateTime(new Date());
		user.setUpdateUserId(ShiroKit.getUser().getId());
		userRepository.save(user);

    }

    @Override
	public void freeze(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			User user = userRepository.findOne(uuid);
			user.setStatus(ManagerStatus.FREEZED.getCode());
			userRepository.save(user);
		}
	}

	@Override
	public void unfreeze(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			User user = userRepository.findOne(uuid);
			user.setStatus(ManagerStatus.OK.getCode());
			userRepository.save(user);
		}
	}

	@Override
	public void updateRoles(String uuids, String roleIds) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			User user = userRepository.findOne(uuid);
			user.setRoleIds(roleIds);
			userRepository.save(user);
		}
	}

	@Override
	public Map<String, String> findUserInfoByUuid(String uuid) {
		return userRepository.findUserInfoByUuid(uuid);
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll(new Specification<User>(){
			@Override
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				list.add(cb.notEqual(root.get("uuid").as(String.class), "00000000000000000000000000000001"));
				Predicate[] pre = new Predicate[list.size()];
				return query.where(list.toArray(pre)).getRestriction();
			}
		});
	}

	@Override
	public List<User> findByUuidIn(List<String> ids) {
		return userRepository.findByUuidIn(ids);
	}

	@Override
	public List<User> findByUuidInAndNameLike(List<String> ids, String name) {
		return userRepository.findByUuidInAndNameLike(ids, name);
	}
}
