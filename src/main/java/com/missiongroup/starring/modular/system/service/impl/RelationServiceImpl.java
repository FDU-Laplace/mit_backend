package com.missiongroup.starring.modular.system.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.missiongroup.starring.modular.system.domain.Relation;
import com.missiongroup.starring.modular.system.repository.RelationRepository;
import com.missiongroup.starring.modular.system.service.RelationService;

@Component("relationService")
@Transactional
public class RelationServiceImpl implements RelationService {
	private final RelationRepository relationRepository;

	public RelationServiceImpl(RelationRepository relationRepository) {
		this.relationRepository = relationRepository;
	}

	@Override
	public <S extends Relation> S save(S entity) {
		return relationRepository.save(entity);
	}

	@Override
	public Relation findOneByUuid(String uuid) {
		return relationRepository.findOne(uuid);
	}

	@Override
	public Page<Relation> findAll(Pageable pageable) {
		return relationRepository.findAll(pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			relationRepository.delete(uuid);
		}
	}

	@Override
	public List<Relation> findByUuids(String uuids) {
		List<Relation> relations = new ArrayList<Relation>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			relations.add(relationRepository.findOne(uuid));
		}
		return relations;
	}

	@Override
	public List<String> getResUrlsByRoleId(String uuid) {
		return relationRepository.getResUrlsByRoleId(uuid);
	}

	@Override
	public List<String> findMenusIdsByRoleId(String roleId) {
		return relationRepository.findMenusIdsByRoleId(roleId);
	}

	@Override
	public void deleteAllByRoleId(String roleId) {
		relationRepository.deleteAllByRoleId(roleId);
	}
}
