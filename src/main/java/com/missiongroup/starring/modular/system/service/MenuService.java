package com.missiongroup.starring.modular.system.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.missiongroup.starring.modular.system.domain.Menu;

public interface MenuService {
	<S extends Menu> S save(S entity);

	Menu findOneByUuid(String uuid);

	Menu findOneByCode(String code);

	List<Menu> findByUuids(String uuids);

	void delete(String uuids);

	Page<Menu> findAll(Pageable pageable);

	void dragSortMenus(String[] ids, String[] nums);

	void updateStatus(String menuIds, Integer status);

	List<Menu> getMenusByRoleIds(List<String> roleIds);

	List<String> getBtnsByRoleIds(List<String> roleList);

	List<Menu> findAllMenus(Menu menu);
	
	List<Menu> findAllMenus();
	
	List<Menu> findAll();
	
	Integer findMaxSort(String parentId);
}
