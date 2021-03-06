package com.missiongroup.starring.modular.system.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import lombok.experimental.var;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.Const;
import com.missiongroup.starring.common.constant.cache.Cache;
import com.missiongroup.starring.common.constant.cache.CacheKey;
import com.missiongroup.starring.common.constant.dictmap.RoleDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.cache.CacheKit;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroDbRealm;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.shiro.ShiroUser;
import com.missiongroup.starring.core.support.BeanKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.domain.dto.MenuDto;
import com.missiongroup.starring.modular.system.domain.dto.RoleDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.MenuWarpper;
import com.missiongroup.starring.modular.system.domain.dto.warpper.RoleWarpper;
import com.missiongroup.starring.modular.system.service.DepartService;
import com.missiongroup.starring.modular.system.service.MenuService;
import com.missiongroup.starring.modular.system.service.RelationService;
import com.missiongroup.starring.modular.system.service.RoleService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * ???????????????
 *
 * @author mission
 * @Date 2017???2???12???21:59:14
 */
@SuppressWarnings("all")
@Api(value = "??????????????????", description = "??????????????????")
@Controller
@RequestMapping("/roleCtl")
public class RoleController extends BaseController {
	@Autowired
	RoleService roleService;

	@Autowired
	DepartService departService;

	@Resource
	MenuService menuService;

	@Autowired
	RelationService relationService;

	@ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParam(name = "role", value = "????????????", required = true, dataType = "Role")
	@RequestMapping(value = "/role", method = RequestMethod.POST)
	@BussinessLog(value = "??????????????????", key = "name,departId,remark", dict = RoleDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody Role role, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		// ??????????????????????????????
		Role theRole = roleService.findOneByName(role.getName());
		if (theRole != null) {
			throw new BussinessException(BizExceptionEnum.ROLE_ALREADY_REG);
		}
		role.setUuid(null);
		// ????????????????????????????????????
		Integer maxSort = roleService.findMaxSort();
		if (maxSort == null) {
			maxSort = 1;
		} else {
			maxSort++;
		}
		role.setSort(maxSort);
		role.setCreateTime(new Date());
		role.setUpdateTime(new Date());
		role.setCreateUserId(ShiroKit.getUser().getId());
		role.setUpdateUserId(ShiroKit.getUser().getId());
		roleService.save(role);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "??????????????????", notes = " ??????????????????")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "roleId", value = "??????ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "role", value = "????????????", required = true, dataType = "Role")//
	})
	@RequestMapping(value = "/role/{roleId}", method = RequestMethod.PUT)
	@BussinessLog(value = "??????????????????", key = "name,departId,remark", dict = RoleDict.class)
	@ResponseBody
	public Object edit(@PathVariable("roleId") String roleId, @Valid @RequestBody Role role, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		role.setUuid(roleId);
		Role cacheRole = (Role) LogObjectHolder.me().get();
		// ????????????????????????????????????????????????????????????
		if (!cacheRole.getName().equals(role.getName())) {
			// ??????????????????????????????
			Role theRole = roleService.findOneByName(role.getName());
			if (theRole != null) {
				throw new BussinessException(BizExceptionEnum.ROLE_ALREADY_REG);
			}
		}
		cacheRole.setName(role.getName());
		cacheRole.setDepartId(role.getDepartId());
		cacheRole.setRemark(role.getRemark());
		cacheRole.setUpdateTime(new Date());
		cacheRole.setUpdateUserId(ShiroKit.getUser().getId());
		cacheRole = roleService.save(cacheRole);
		CacheKit.removeAll(Cache.CONSTANT);
		// ????????????????????????
		if (cacheRole == null) {
			return new ErrorTip(404, "????????????");
		}
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParam(name = "roleIds", value = "??????ID", required = true, dataType = "String")
	@RequestMapping(value = "/role/{roleIds}", method = RequestMethod.DELETE)
	@BussinessLog(value = "??????????????????", key = "roleIds", dict = RoleDict.class)
	@ResponseBody
	public Object delete(@PathVariable("roleIds") String roleIds) {
		if (ToolUtil.validateParam(roleIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		// ?????????????????????????????????
		String[] ids = roleIds.split(",");
		for (String id : ids) {
			if (id.equals(String.valueOf(Const.ADMIN_ROLE_ID))) {
				throw new BussinessException(BizExceptionEnum.CANT_DELETE_ADMIN);
			}
		}
		roleService.delete(roleIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "??????????????????", notes = "??????roleId??????????????????")
	@ApiImplicitParam(name = "roleId", value = "??????ID", required = true, dataType = "String")
	@RequestMapping(value = "/role/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoleById(@PathVariable("roleId") String roleId) {
		if (ToolUtil.validateParam(roleId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		Role role = roleService.findOneByUuid(roleId);
		if(role.getDepartId()!=null){
			String parentIds = departService.findParentIdsByUuid(role.getDepartId());
		}
		Map<String, Object> map = BeanKit.beanToMap(role);

		//map.put("parent_ids", (parentIds != null ? parentIds.replace("[", "").replace("]", "").split(","):new ArrayList<String>()));
		LogObjectHolder.me().set(role);
		return map;
	}

	@ApiOperation(value = "??????????????????????????????", notes = "??????????????????????????????")
	@ApiImplicitParam(name = "pageParam", value = "??????????????????", required = true, dataType = "PageParam")
	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		Page<Role> roleList = roleService.findAll(pageParam.formatPageable(), pageParam.getCondition());
		//System.out.println("24234" + pageParam.getCondition());
		PageResult pageResult = new PageResult(roleList);
		pageResult.setRows((List<Role>) new RoleWarpper(pageResult.getRows()).warp());
		//String json = JSON.toJSONString(pageResult.getRows());
//		String json = JSON.toJSONString(roleList.getContent());
//		System.out.println(json);
		//System.out.println(json);
//		JSONArray jsonVar = JSONArray.parseArray(json);
//		for(int i = 0; i < jsonVar.size(); i++){
//			JSONObject obj = (JSONObject) jsonVar.get(i);
//			System.out.println("243"+obj.getString("id"));
//		}
		//System.out.println("235345345");
		return pageResult;
	}

	@ApiOperation(value = "??????????????????????????????", notes = "??????????????????????????????????????????????????????")
	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	@ResponseBody
	public Object roleList() {
		List<Role> roles = roleService.findAll();
		List<RoleDto> roleDtos = (List<RoleDto>) new RoleWarpper(roles).warp();
		return roleDtos;
	}

	@ApiOperation(value = "??????????????????", notes = "??????????????????")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "roleId", value = "??????ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "ids", value = "??????ID", required = true, dataType = "String")//

	})
	@RequestMapping(value = "/role/setAuthority", method = RequestMethod.PUT)
	@BussinessLog(value = "??????????????????", key = "roleId,ids", dict = RoleDict.class)
	@ResponseBody
	public Object setAuthority(@RequestParam("roleId") String roleId, @RequestParam("ids") String ids) {
		if (ToolUtil.isOneEmpty(roleId, ids)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		roleService.updateAuthority(roleId, ids);
		// ??????????????????????????? ????????????
		ShiroUser shiroUser = ShiroKit.getUser();
		if (shiroUser.getRoleList().contains(roleId)) {
			refreshPermission();
		}
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "????????????????????????", notes = "????????????????????????")
	@ApiImplicitParam(name = "roleId", value = "??????ID", required = true, dataType = "String")
	@RequestMapping(value = "/role/permissionTree/{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getRoleMenusTreeList(@PathVariable("roleId") String roleId) {
		if (ToolUtil.validateParam(roleId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		List<Menu> menus = menuService.findAll();
		List<MenuDto> menuDtos = (List<MenuDto>) new MenuWarpper(menus).warp();
		List<String> ids = relationService.findMenusIdsByRoleId(roleId);
		try {
			menuDtos = factorTree2(menuDtos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		HashMap<String, Object> map = new HashMap<>();
		map.put("tree", menuDtos);
		map.put("ids", ids);
		return map;
	}

	/**
	 * ????????????
	 */
	private void refreshPermission() {
		RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
		ShiroDbRealm shiroRealm = (ShiroDbRealm) rsm.getRealms().iterator().next();
		Subject subject = SecurityUtils.getSubject();
		String realmName = subject.getPrincipals().getRealmNames().iterator().next();

		// ???????????????????????????,??????????????????realmName,test???????????????????????????
		SimplePrincipalCollection principals = new SimplePrincipalCollection(ShiroKit.getUser().getAccount(), realmName);
		shiroRealm.getAuthorizationCache().remove(subject.getPrincipals());
		subject.releaseRunAs();
	}
}
