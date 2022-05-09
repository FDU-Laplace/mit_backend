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

import com.missiongroup.starring.modular.system.domain.Relation;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.repository.RelationRepository;
import com.missiongroup.starring.modular.system.repository.RoleRepository;
import com.missiongroup.starring.modular.system.service.RoleService;

@Component("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {
	private final RoleRepository roleRepository;

	private final RelationRepository relationRepository;

	public RoleServiceImpl(RoleRepository roleRepository, RelationRepository relationRepository) {
		this.roleRepository = roleRepository;
		this.relationRepository = relationRepository;
	}

	@Override
	public <S extends Role> S save(S entity) {
		return roleRepository.save(entity);
	}

	@Override
	public Role findOneByUuid(String uuid) {
		return roleRepository.findOne(uuid);
	}

	@Override
	public Page<Role> findAll(Pageable pageable, Map<String, Object> condition) {
		return roleRepository.findAll(new Specification<Role>() {
			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				if (null != condition) {
					List<Predicate> list = new ArrayList<Predicate>();

					if (StringUtils.isNotBlank((String) condition.get("name"))) {
						list.add(cb.like(root.get("name").as(String.class), "%" + ((String) condition.get("name")).replace("_", "\\_").replace("%", "\\%") + "%"));
					}
					if (StringUtils.isNotBlank((String) condition.get("departId"))) {
						list.add(cb.equal(root.get("departId").as(String.class), (String) condition.get("departId")));
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
			roleRepository.delete(uuid);
		}
	}

	@Override
	public List<Role> findByUuids(String uuids) {
		List<Role> roles = new ArrayList<Role>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			roles.add(roleRepository.findOne(uuid));
		}
		return roles;
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAllOrderByUpdateTime();
	}

	@Override
	public Role findOneByName(String name) {
		return roleRepository.findOneByName(name);
	}

	@Override
	public Integer findMaxSort() {
		return roleRepository.findMaxSort();
	}

	@Override
	public void updateAuthority(String roleId, String ids) {
		// 删除该角色所有的权限
		relationRepository.deleteAllByRoleId(roleId);
		String[] menuIds = ids.split(",");
		// 添加新的权限
		for (String id : menuIds) {
			Relation relation = new Relation();
			relation.setRoleId(roleId);
			relation.setMenuId(id);
			relationRepository.save(relation);
		}
	}
}
