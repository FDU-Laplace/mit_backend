package com.missiongroup.starring.modular.system.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.dto.MenuDto;

/**
 * 菜单列表的包装类
 *
 * @author mission
 * @date 2017年2月19日15:07:29
 */
public class MenuWarpper extends BaseWarpper {
	public MenuWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {
	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof Menu) {
			MenuDto menuDto = new MenuDto();
			Menu menu = (Menu) entity;
			menuDto.setId(menu.getUuid());
			menuDto.setCode(menu.getCode());
			menuDto.setParentId(menu.getParentId());
			menuDto.setParentIds(menu.getParentIds());
			menuDto.setName(menu.getName());
			menuDto.setIcon(menu.getIcon());
			menuDto.setUrl(menu.getUrl());
			menuDto.setNum(menu.getNum());
			menuDto.setLevel(menu.getLevel());
			menuDto.setType(menu.getType());
			menuDto.setRemark(menu.getRemark());
			menuDto.setStatus(menu.getStatus());
			menuDto.setCreateTime(menu.getCreateTime());
			menuDto.setUpdateTime(menu.getUpdateTime());
			menuDto.setCreateUserId(menu.getCreateUserId());
			menuDto.setUpdateUserId(menu.getUpdateUserId());
			menuDto.setLabel(menu.getName());
			menuDto.setValue(menu.getUuid());
			return menuDto;
		}
		return null;
	}
}
