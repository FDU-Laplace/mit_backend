package com.missiongroup.starring.modular.system.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
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
import com.missiongroup.starring.common.constant.dictmap.UserDict;
import com.missiongroup.starring.common.domain.PageParam;
import com.missiongroup.starring.common.domain.PageResult;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.base.tips.ErrorTip;
import com.missiongroup.starring.core.log.LogObjectHolder;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.Role;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.domain.dto.UserDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.UserWarpper;
import com.missiongroup.starring.modular.system.service.RoleService;
import com.missiongroup.starring.modular.system.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: UserController
 * @Description: 用户管理模块控制器
 * @author TAIHUAYUN
 * @date 2018年4月16日 下午4:55:26
 *
 */
@SuppressWarnings("all")
@Api(value = "用户管理接口")
@Controller
@RequestMapping("/userCtl")
public class UserController extends BaseController {
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@ApiOperation(value = "查询用户信息", notes = "根据userId获取用户信息")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getUserById(@PathVariable("userId") String userId) {
		if (ToolUtil.validateParam(userId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		//System.out.println("awegsvdfgbesrd");
		User user = userService.findOneByUuid(userId);
		LogObjectHolder.me().set(user);
		return user;
	}

	@ApiOperation(value = "查询用户信息", notes = "根据userName获取用户信息")
	@ApiImplicitParam(name = "userName", value = "用户Name", required = true, dataType = "String")
	@RequestMapping(value = "/user1/{userName}", method = RequestMethod.GET)
	@ResponseBody
	public Object getUserByName(@PathVariable("userName") String userName) {
		if (ToolUtil.validateParam(userName)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		//System.out.println("awegsvdfgbesrd");
		User user = userService.findOneByAccount(userName);
		LogObjectHolder.me().set(user);
		return user;
	}

	/**
	 *
	 * @MethodName: UserController
	 * @Description: 用户管理模块控制器
	 * @author TAIHUAYUN
	 * @date 2018年4月16日 下午4:55:26
	 *
	 */
	@ApiOperation(value = "获取所有用户信息列表", notes = "获取所有用户信息列表")
	@ApiImplicitParam(name = "pageParam", value = "分页查询参数", required = true, dataType = "PageParam")
	@RequestMapping(value = "/users", method = RequestMethod.POST)
	@ResponseBody
	public PageResult list(@RequestBody PageParam pageParam) {
		//Page<User> userList = userService.findAll(pageParam.formatPageable(), pageParam.getCondition());

		if(pageParam.getCondition().containsKey("name")){
			//System.out.println("234234"+pageParam.getCondition());
			Page<Role> roleList = roleService.findAll(pageParam.formatPageable(), pageParam.getCondition());

			//String pageParamJSONString = JSON.toJSONString(pageParam.getCondition());
			//System.out.println("egergfer"+pageParam.getCondition().get("beginTime"));
			//String beginTime = pageParamJSONString.get(0);
			//JSONObject roleListJSONObj = (JSONObject) pageParamJSONString;

			String beginTime = (String) pageParam.getCondition().get("beginTime");
			String endTime = (String) pageParam.getCondition().get("endTime");

			String roleListJSONString = JSON.toJSONString(roleList.getContent());
			System.out.println("sfgsdg"+roleListJSONString);
			//System.out.println(json);
			JSONArray roleListJSONArray = JSONArray.parseArray(roleListJSONString);

			JSONObject roleListJSONObj = (JSONObject) roleListJSONArray.get(0);
			System.out.println("sfgsvdsvdg"+roleListJSONObj);
			String roleId = roleListJSONObj.getString("uuid");
			//System.out.println("2533dsgds"+roleListJSONObj.getString("beginTime"));
			//System.out.println("4324"+str);
			Map<String, Object> map = new HashMap<String, Object>(){
				{
					put("roleIds", roleId);
					put("beginTime", beginTime);
					put("endTime", endTime);
				}
			};
//			for(int i = 0; i < jsonVar.size(); i++){
//				JSONObject obj = (JSONObject) jsonVar.get(i);
//				System.out.println("243"+obj.getString("uuid"));
//			}

			pageParam.setCondition(map);
			//System.out.println("zsdgsdrgb"+pageParam.getCondition());
			Page<User> userList = userService.findAll(pageParam.formatPageable(), pageParam.getCondition());
			PageResult pageResult = new PageResult(userList);
			pageResult.setRows((List<UserDto>) new UserWarpper(pageResult.getRows()).warp());
			return pageResult;
		}
			Page<User> userList = userService.findAll(pageParam.formatPageable(), pageParam.getCondition());
//			System.out.println("35r345sdfg" + pageParam.getCondition().containsKey("beginTime"));
			PageResult pageResult = new PageResult(userList);
			pageResult.setRows((List<UserDto>) new UserWarpper(pageResult.getRows()).warp());
			return pageResult;

	}

	@ApiOperation(value = "新增用户信息", notes = "新增用户信息")
	@ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "User")
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@BussinessLog(value = "新增用户信息", key = "account,name,email,phone,departId,status,sex", dict = UserDict.class)
	@ResponseBody
	public Object add(@Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}

		// 判断账号是否重复
		User theUser = userService.findOneByAccount(user.getAccount());
		if (theUser != null) {
			throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
		}

		User theUser2 = userService.findOneByEmail(user.getEmail());
		if (theUser2 != null) {
			throw new BussinessException(BizExceptionEnum.USER_EMAIL_REG);
		}
		// 完善账号信息
		user.setSalt(ShiroKit.getRandomSalt(5));
		user.setPassword(ShiroKit.md5(Const.DEFAULT_PWD, user.getSalt()));
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setDepartId("00000000000000000000000000000001");
		user.setCreateUserId(ShiroKit.getUser().getId());
		user.setUpdateUserId(ShiroKit.getUser().getId());

		userService.save(user);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "更新用户信息", notes = "根据userId更新部门信息")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "UserDto")//
	})
	@RequestMapping(value = "/user/{userId}", method = RequestMethod.PUT)
	@BussinessLog(value = "更新用户信息", key = "account,name,email,phone,departId,status,sex", dict = UserDict.class)
	@ResponseBody
	public Object edit(@PathVariable("userId") String userId, @Valid @RequestBody User user, BindingResult result) {
		if (result.hasErrors()) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		user.setUuid(userId);
		User cacheUser = (User) LogObjectHolder.me().get();
		// 账号被修改，且被修改的账号已存在
		if (!user.getAccount().equals(cacheUser.getAccount())) {
			User theUser = userService.findOneByAccount(user.getAccount());
			// 判断账号是否重复
			if (theUser != null) {
				throw new BussinessException(BizExceptionEnum.USER_ALREADY_REG);
			}
		}
		// 邮箱被修改了，且被修改的邮箱已存在
		if (!user.getEmail().equals(cacheUser.getEmail())) {
			// 判断邮箱是否已经注册
			User theUser2 = userService.findOneByEmail(user.getEmail());
			if (theUser2 != null) {
				throw new BussinessException(BizExceptionEnum.USER_EMAIL_REG);
			}
		}

		cacheUser.setAccount(user.getAccount());
		cacheUser.setName(user.getName());
		cacheUser.setSex(user.getSex());
		cacheUser.setEmail(user.getEmail());
		cacheUser.setPhone(user.getPhone());
		cacheUser.setStatus(user.getStatus());
		cacheUser.setDepartId(user.getDepartId());
		cacheUser.setDepartIdPath(user.getDepartIdPath());
		cacheUser.setUpdateTime(new Date());
		cacheUser.setUpdateUserId(ShiroKit.getUser().getId());
		cacheUser = userService.save(cacheUser);

		// 判断是否修改成功
		if (cacheUser == null) {
			return new ErrorTip(404, "修改失败");
		}
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "删除用户信息", notes = "删除用户信息")
	@ApiImplicitParam(name = "userIds", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/{userIds}", method = RequestMethod.DELETE)
	@BussinessLog(value = "删除用户信息", key = "userIds", dict = UserDict.class)
	@ResponseBody
	public Object delete(@PathVariable("userIds") String userIds) {
		if (ToolUtil.validateParam(userIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		// 不能删除超级管理员
		String[] ids = userIds.split(",");
		for (String id : ids) {
			if (id.equals(String.valueOf(Const.ADMIN_ID))) {
				throw new BussinessException(BizExceptionEnum.CANT_DELETE_ADMIN);
			}
		}
		userService.delete(userIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "重置用户的密码", notes = "重置用户的密码")
	@ApiImplicitParam(name = "userIds", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/resetPassword", method = RequestMethod.PUT)
	@BussinessLog(value = "重置用户密码", key = "userIds", dict = UserDict.class)
	@ResponseBody
	public Object resetPassord(@RequestParam String userIds) {
		if (ToolUtil.validateParam(userIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		userService.resetPassword(userIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "修改用户的密码", notes = "修改用户的密码")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "user", value = "用户信息", required = true, dataType = "UserDto")//
	})
	@RequestMapping(value = "/user/updatePassword/{userId}", method = RequestMethod.PUT)
	@BussinessLog(value = "修改用户密码", key = "userIds", dict = UserDict.class)
	@ResponseBody
	public Object updatePassord(@PathVariable("userId") String userId, @Valid @RequestBody User user, BindingResult result) {
		System.out.println("gfdsgds"+user.getPassword());
		if (ToolUtil.validateParam(userId)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		userService.updatePassword(userId, user.getPassword());
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "禁用用户", notes = "禁用用户")
	@ApiImplicitParam(name = "userIds", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/freeze", method = RequestMethod.PUT)
	@BussinessLog(value = "禁用用户", key = "userIds", dict = UserDict.class)
	@ResponseBody
	public Object freeze(@RequestParam String userIds) {
		if (ToolUtil.validateParam(userIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		// 不能冻结超级管理员
		String[] ids = userIds.split(",");
		for (String id : ids) {
			if (id.equals(String.valueOf(Const.ADMIN_ID))) {
				throw new BussinessException(BizExceptionEnum.CANT_FREEZE_ADMIN);
			}
		}

		userService.freeze(userIds);

		return SUCCESS_TIP;
	}

	@ApiOperation(value = "启用用户", notes = "启用用户")
	@ApiImplicitParam(name = "userIds", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/unfreeze", method = RequestMethod.PUT)
	@BussinessLog(value = "启用用户", key = "userIds", dict = UserDict.class)
	@ResponseBody
	public Object unfreeze(@RequestParam String userIds) {
		if (ToolUtil.validateParam(userIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}
		userService.unfreeze(userIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "用户分配角色", notes = "用户分配角色")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "userIds", value = "用户ID", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "roleIds", value = "角色ID", required = true, dataType = "String")//
	})
	@RequestMapping(value = "/user/setRole", method = RequestMethod.PUT)
	@BussinessLog(value = "用户分配角色", key = "userIds,roleIds", dict = UserDict.class)
	@ResponseBody
	public Object setRole(@RequestParam("userIds") String userIds, @RequestParam("roleIds") String roleIds) {
		if (ToolUtil.isOneEmpty(userIds, roleIds)) {
			throw new BussinessException(BizExceptionEnum.REQUEST_PARAM);
		}

		// 不能修改超级管理员
		String[] ids = userIds.split(",");
		for (String id : ids) {
			if (id.equals(String.valueOf(Const.ADMIN_ID))) {
				throw new BussinessException(BizExceptionEnum.CANT_CHANGE_ADMIN);
			}
		}
		userService.updateRoles(userIds, roleIds);
		return SUCCESS_TIP;
	}

	@ApiOperation(value = "获取用户角色", notes = "获取用户角色")
	@ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "String")
	@RequestMapping(value = "/user/roles/{userId}", method = RequestMethod.GET)
	@ResponseBody
	public Object getUserRoles(@PathVariable("userId") String userId) {
		User user = userService.findOneByUuid(userId);
		String roleIds = user.getRoleIds();
		List<Role> roles = null;
		if (ToolUtil.isNotEmpty(roleIds)) {
			roles = roleService.findByUuids(roleIds);
		}
		return roles;
	}
	
	/*@ApiOperation(value = "获取所有用户信息列表", notes = "获取所有用户信息列表")
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	@ResponseBody
	public Object list() {
		List<User> userList = userService.findAll();
		return new UserWarpper(userList).warp();
	}*/
}
