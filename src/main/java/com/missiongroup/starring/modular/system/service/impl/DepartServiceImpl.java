package com.missiongroup.starring.modular.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Depart;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.repository.DepartRepository;
import com.missiongroup.starring.modular.system.repository.RoleRepository;
import com.missiongroup.starring.modular.system.repository.UserRepository;
import com.missiongroup.starring.modular.system.service.DepartService;

@SuppressWarnings("all")
@Component("departService")
@Transactional
public class DepartServiceImpl implements DepartService {
	@Autowired
	private DepartRepository departRepository;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public <S extends Depart> S save(S entity) {
		S depart = departRepository.save(entity);
		if (entity.getUuid() != null) {
			List<Depart> subDeparts = departRepository.findAll(new Specification<Depart>() {
				@Override
				public Predicate toPredicate(Root<Depart> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					list.add(cb.like(root.get("parentIds").as(String.class), "%[" + entity.getUuid() + "]%"));
					Predicate[] pre = new Predicate[list.size()];
					return query.where(list.toArray(pre)).getRestriction();
				}
			});
			if (ToolUtil.isNotEmpty(subDeparts)) {
				for (Depart subDepart : subDeparts) {
					departSetPids(subDepart);
					subDepart.setUpdateTime(new Date());
					subDepart.setUpdateUserId(ShiroKit.getUser().getId());
					departRepository.save(subDepart);
				}
			}
		}
		return depart;
	}

	@Override
	public Depart findOneByUuid(String uuid) {
		return departRepository.findOne(uuid);
	}

	@Override
	public Page<Depart> findAll(Pageable pageable) {
		return departRepository.findAll(pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			List<User> users = userRepository.findAllByDepartId(uuid);
			if (ToolUtil.isNotEmpty(users)) {
				throw new BussinessException(BizExceptionEnum.DEPART_NOT_DELETE_USER);
			}
			List<Role> roles = roleRepository.findAllByDepartId(uuid);
			if (ToolUtil.isNotEmpty(roles)) {
				throw new BussinessException(BizExceptionEnum.DEPART_NOT_DELETE_ROLE);
			}
			departRepository.delete(uuid);
		}
	}

	@Override
	public List<Depart> findByUuids(String uuids) {
		List<Depart> departs = new ArrayList<Depart>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			departs.add(departRepository.findOne(uuid));
		}
		return departs;
	}

	@Override
	public List<Depart> findByParentIdsLike(String parentIds) {
		return departRepository.findByParentIdsLike(parentIds);
	}

	@Override
	public List<Depart> findAll() {
		return departRepository.findAll();
	}

	@Override
	public Depart findOneByName(String name) {
		return departRepository.findOneByName(name);
	}

	@Override
	public Integer findMaxSort(String parentId) {
		return departRepository.findMaxSort(parentId);
	}

	@Override
	public String findParentIdsByUuid(String uuid) {
		return departRepository.findParentIdsByUuid(uuid);
	}
	
	private void departSetPids(Depart depart) {
		if (ToolUtil.isEmpty(depart.getParentId()) || "0".equals(depart.getParentId())) {
			depart.setParentId("0");
			depart.setParentIds("[0],");
		} else {
			String pid = depart.getParentId();
			Depart temp = departRepository.findOne(pid);
			String pids = temp.getParentIds();
			depart.setParentId(pid);
			depart.setParentIds(pids + "[" + pid + "],");
		}
	}
}
