package com.missiongroup.starring.modular.system.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Depart;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.repository.MenuRepository;
import com.missiongroup.starring.modular.system.service.MenuService;

@SuppressWarnings("all")
@Component("menuService")
@Transactional
public class MenuServiceImpl implements MenuService {
	private final MenuRepository menuRepository;

	public MenuServiceImpl(MenuRepository menuRepository) {
		this.menuRepository = menuRepository;
	}

	@Override
	public <S extends Menu> S save(S entity) {
		S menu = menuRepository.save(entity);
		if (menu.getUuid() != null) {
			List<Menu> subMenus = menuRepository.findAll(new Specification<Menu>() {
				@Override
				public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					List<Predicate> list = new ArrayList<Predicate>();
					list.add(cb.like(root.get("parentIds").as(String.class), "%[" + entity.getUuid() + "]%"));
					Predicate[] pre = new Predicate[list.size()];
					return query.where(list.toArray(pre)).getRestriction();
				}
			});
			if (ToolUtil.isNotEmpty(subMenus)) {
				for (Menu subMenu : subMenus) {
					menuSetPcode(subMenu);
					subMenu.setUpdateTime(new Date());
					subMenu.setUpdateUserId(ShiroKit.getUser().getId());
					menuRepository.save(subMenu);
				}
			}
		}
		return menu;
	}

	@Override
	public Menu findOneByUuid(String uuid) {
		return menuRepository.findOne(uuid);
	}

	@Override
	public Page<Menu> findAll(Pageable pageable) {
		return menuRepository.findAll(pageable);
	}

	@Override
	public void delete(String uuids) {
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			menuRepository.delete(uuid);
		}
	}

	@Override
	public List<Menu> findByUuids(String uuids) {
		List<Menu> menus = new ArrayList<Menu>();
		String[] ids = uuids.split(",");
		for (String uuid : ids) {
			menus.add(menuRepository.findOne(uuid));
		}
		return menus;
	}

	@Override
	public Menu findOneByCode(String code) {
		return menuRepository.findOneByCode(code);
	}

	@Override
	public void dragSortMenus(String[] ids, String[] nums) {
		for (int i = 0; i < ids.length; i++) {
			Menu menu = menuRepository.findOne(ids[i]);
			menu.setNum(Integer.valueOf(nums[i]));
			menu.setUpdateTime(new Date());
			menu.setUpdateUserId(ShiroKit.getUser().getId());
			menuRepository.save(menu);
		}
	}

	@Override
	public void updateStatus(String menuIds, Integer status) {
		String[] ids = menuIds.split(",");
		for (String id : ids) {
			Menu menu = menuRepository.findOne(id);
			menu.setStatus(status);
			menu.setUpdateTime(new Date());
			menu.setUpdateUserId(ShiroKit.getUser().getId());
			menuRepository.save(menu);
		}
	}

	@Override
	public List<Menu> getMenusByRoleIds(List<String> roleIds) {
		if (roleIds.size() < 1) {
			return null;
		}
		List<Object[]> result = menuRepository.getMenusByRoleIds(roleIds);
		List<Menu> dtoList = new ArrayList<Menu>();
		for (Object[] item : result) {
			Menu dto = new Menu();
			dto.setUuid((String) item[0]);
			dto.setIcon((String) item[1]);
			dto.setParentId((String) item[2]);
			dto.setCode((String) item[3]);
			dto.setName((String) item[4]);
			dto.setUrl((String) item[5]);
			dto.setLevel((Integer) item[6]);
			dto.setType((Integer) item[7]);
			dto.setNum((Integer) item[8]);
			dtoList.add(dto);
		}
		return dtoList;
	}

	@Override
	public List<String> getBtnsByRoleIds(List<String> roleIds) {
		if (roleIds.size() < 1) {
			return null;
		}
		return menuRepository.getBtnsByRoleIds(roleIds);
	}

	@Override
	public List<Menu> findAllMenus(Menu menu) {
		return menuRepository.findAll(new Specification<Menu>() {
			@Override
			public Predicate toPredicate(Root<Menu> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> list = new ArrayList<Predicate>();

				if (StringUtils.isNotBlank(menu.getName())) {
					list.add(cb.like(root.get("name").as(String.class), "%" + menu.getName().replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank(menu.getCode())) {
					list.add(cb.like(root.get("code").as(String.class), "%" + menu.getCode().replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				if (StringUtils.isNotBlank(menu.getUrl())) {
					list.add(cb.like(root.get("url").as(String.class), "%" + menu.getUrl().replace("_", "\\_").replace("%", "\\%") + "%"));
				}
				Predicate[] pre = new Predicate[list.size()];
				return query.where(list.toArray(pre)).getRestriction();
			}
		});
	}

	@Override
	public List<Menu> findAllMenus() {
		// 查询菜单节点
		return menuRepository.findAllByType(0);
	}

	@Override
	public List<Menu> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Integer findMaxSort(String parentId) {
		return menuRepository.findMaxSort(parentId);
	}
	
	private void menuSetPcode(Menu menu) {
		if (ToolUtil.isEmpty(menu.getParentId()) || "0".equals(menu.getParentId())) {
			menu.setParentId("0");
			menu.setParentIds("[0],");
			menu.setLevel(1);
		} else {
			Menu pMenu = menuRepository.findOne(menu.getParentId());
			Integer pLevels = pMenu.getLevel();
			menu.setParentId(pMenu.getUuid());
			// 如果编号和父编号一致会导致无限递归
			if (menu.getCode().equals(pMenu.getCode())) {
				throw new BussinessException(BizExceptionEnum.MENU_PCODE_COINCIDENCE);
			}
			menu.setLevel(pLevels + 1);
			menu.setParentIds(pMenu.getParentIds() + "[" + pMenu.getUuid() + "],");
		}
	}
}
