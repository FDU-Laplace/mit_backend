package com.missiongroup.starring.modular.system.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.SystemMenuEnum;
import com.missiongroup.starring.common.constant.dictmap.MenuDict;
import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.support.BeanKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.dto.MenuDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.MenuWarpper;
import com.missiongroup.starring.modular.system.service.MenuService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 菜单控制器
 *
 * @author mission
 * @Date 2017年2月12日21:59:14
 */
@SuppressWarnings("all")
@Api(value = "菜单接口详情", description = "菜单接口详情")
@Controller
@RequestMapping("/menuCtl")
public class MenuController extends BaseController {
	@Autowired
	MenuService menuService;

	@ApiOperation(value = "新增菜单信息", notes = "新增菜单信息")
	@ApiImplicitParam(name = "menu", value = "菜单信息", required = true, dataType = "Menu")
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	@BussinessLog(value = "新增菜单信息", key = "name,code,icon,url,type", dict = MenuDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}

		// 判断是否存在该编号
		String existedMenuName = ConstantFactory.me().getMenuNameByCode(menu.getCode());
		if (ToolUtil.isNotEmpty(existedMenuName)) {
			throw new BussinessException(BizExceptionEnum.EXISTED_THE_MENU);
		}

		// 设置父级菜单编号
		menuSetPcode(menu);
		// 获取同级菜单的最大排序号
//		Integer maxSort = menuService.findMaxSort(menu.getParentId());
//		if (maxSort == null) {
//			maxSort = 1;
//		} else {
//			maxSort++;
//		}
//		menu.setNum(maxSort);
		menu.setCreateTime(new Date());
		menu.setUpdateTime(new Date());
		menu.setCreateUserId(ShiroKit.getUser().getId());
		menu.setUpdateUserId(ShiroKit.getUser().getId());

		menuService.save(menu);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "更新菜单信息", notes = "更新菜单信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "menuId", value = "菜单ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "menu", value = "菜单信息", required = true, dataType = "Menu")//
	})
	@RequestMapping(value = "/menu/{menuId}", method = RequestMethod.PUT)
	@BussinessLog(value = "更新菜单信息", key = "name,code,icon,url,type", dict = MenuDict.class)
	@ResponseBody
	public Object edit(@PathVariable("menuId") String menuId, @Valid @RequestBody Menu menu, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		menu.setUuid(menuId);
		Menu cacheMenu = (Menu) LogObjectHolder.me().get();
		// 菜单编号修改了
		if (!cacheMenu.getCode().equals(menu.getCode())) {
			// 判断是否存在该编号
			String existedMenuName = ConstantFactory.me().getMenuNameByCode(menu.getCode());
			if (ToolUtil.isNotEmpty(existedMenuName)) {
				throw new BussinessException(BizExceptionEnum.EXISTED_THE_MENU);
			}
		}
		if (menuId.equals(menu.getParentId())) {
			throw new BussinessException(BizExceptionEnum.MENU_NOT_YOUSELF);
		}
		if (menu.getParentId() != null) {
			Menu parentMenu = menuService.findOneByUuid(menu.getParentId());
			if (parentMenu != null && parentMenu.getParentIds() != null && parentMenu.getParentIds().contains(menuId)) {
				throw new BussinessException(BizExceptionEnum.MENU_NOT_SUBTYPE);
			}
		}
		cacheMenu.setCode(menu.getCode());
		cacheMenu.setName(menu.getName());
		cacheMenu.setUrl(menu.getUrl());
		cacheMenu.setType(menu.getType());
		cacheMenu.setIcon(menu.getIcon());
		cacheMenu.setStatus(menu.getStatus());
		cacheMenu.setParentId(menu.getParentId());
		cacheMenu.setNum(menu.getNum());
		menuSetPcode(cacheMenu);
		cacheMenu.setUpdateTime(new Date());
		cacheMenu.setUpdateUserId(ShiroKit.getUser().getId());
		cacheMenu = menuService.save(cacheMenu);
		// 判断是否修改成功
		if (cacheMenu == null) {
			return new ErrorTip(404, "修改失败");
		}
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "拖拉菜单排序", notes = "拖拉菜单排序")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "menuIds", value = "菜单ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "sorts", value = "序号", required = true, dataType = "String")//
	})
	@RequestMapping(value = "/menu/dragSort", method = RequestMethod.PUT)
	@BussinessLog(value = "拖拉菜单排序", key = "menuIds,sorts", dict = MenuDict.class)
	@ResponseBody
	public Object dragSort(@RequestParam String menuIds, @RequestParam String sorts) {
		if (ToolUtil.isOneEmpty(menuIds, sorts)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		String[] ids = menuIds.split(",");
		String[] nums = sorts.split(",");
		if (ids.length != nums.length) {
			throw new BussinessException(BizExceptionEnum.DRAG_MENU_SORT_ERROR);
		}
		menuService.dragSortMenus(ids, nums);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "查询菜单信息", notes = "根据menuId获取菜单信息")
	@ApiImplicitParam(name = "menuId", value = "菜单ID", required = true, dataType = "String")
	@RequestMapping(value = "/menu/{menuId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getMenuById(@PathVariable("menuId") String menuId) {
		if (ToolUtil.validateParam(menuId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Menu menu = menuService.findOneByUuid(menuId);
		String parentIds = menu.getParentIds().replace("[", "").replace("]", "");
		menu.setParentIds(parentIds);
		Map<String, Object> menuMap = BeanKit.beanToMap(menu);
		menuMap.put("parent_ids", parentIds.split(","));
		LogObjectHolder.me().set(menu);
		return menuMap;
	}

	@ApiOperation(value = "更新菜单状态", notes = "更新菜单状态")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "menuIds", value = "菜单ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "status", value = "菜单状态", required = true, dataType = "Integer")//
	})
	@RequestMapping(value = "/menu/setStatus", method = RequestMethod.PUT)
	@BussinessLog(value = "更新菜单状态", key = "menuIds,status", dict = MenuDict.class)
	@ResponseBody
	public Object setStatus(@RequestParam String menuIds, @RequestParam Integer status) {
		if (ToolUtil.validateParam(menuIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		String[] ids = menuIds.split(",");
		if (status == 2) {
			List<String> mustMenuIds = SystemMenuEnum.getMustMenuIds();
			for (String id : ids) {
				if (mustMenuIds.contains(id)) {
					throw new BussinessException(BizExceptionEnum.MENU_NOT_STATE_OFF_MUST);
				}
			}
		}
		// 修改菜单状态 启用 禁用
		menuService.updateStatus(menuIds, status);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "获取菜单和按钮树", notes = "获取菜单和按钮树")
	@ApiImplicitParam(name = "menu", value = "查询条件", required = false, dataType = "Menu")
	@RequestMapping(value = "/menus", method = RequestMethod.POST)
	@ResponseBody
	public Object list(@RequestBody Menu menu) {
		List<Menu> menus = menuService.findAllMenus(menu);
		List<MenuDto> menuDtos = (List<MenuDto>) new MenuWarpper(menus).warp();
		try {
			menuDtos = factorTree(menuDtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuDtos;
	}

	@ApiOperation(value = "获取菜单树", notes = "获取菜单树")
	@RequestMapping(value = "/tree", method = RequestMethod.GET)
	@ResponseBody
	public Object menuTree() throws Exception {
		List<Menu> menus = menuService.findAllMenus();
		List<MenuDto> menuDtos = (List<MenuDto>) new MenuWarpper(menus).warp();
		menuDtos = factorTree2(menuDtos);
		return menuDtos;
	}

	@ApiOperation(value = "删除菜单信息", notes = "删除菜单信息")
	@ApiImplicitParam(name = "menuIds", value = "菜单ID", required = true, dataType = "String")
	@RequestMapping(value = "/menu/{menuIds}", method = RequestMethod.DELETE)
	@BussinessLog(value = "删除菜单信息", key = "menuIds", dict = MenuDict.class)
	@ResponseBody
	public Object delete(@PathVariable("menuIds") String menuIds) {
		if (ToolUtil.validateParam(menuIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		String[] ids = menuIds.split(",");
		List<String> mustMenuIds = SystemMenuEnum.getMustMenuIds();
		for (String id : ids) {
			if (mustMenuIds.contains(id)) {
				throw new BussinessException(BizExceptionEnum.MENU_NOT_DELETE_MUST);
			}
		}
		menuService.delete(menuIds);
		return SUCCESS_TIP;
	}

	/**
	 * 根据请求的父级菜单编号设置pcode和层级
	 */
	private void menuSetPcode(Menu menu) {
		if (ToolUtil.isEmpty(menu.getParentId()) || "0".equals(menu.getParentId())) {
			menu.setParentId("0");
			menu.setParentIds("[0],");
			menu.setLevel(1);
		} else {
			Menu pMenu = menuService.findOneByUuid(menu.getParentId());
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
