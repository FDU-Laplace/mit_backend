package com.missiongroup.starring.modular.system.controller;

import static com.missiongroup.starring.core.support.HttpKit.getIp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Constants;
import com.missiongroup.starring.common.annotion.BussinessLog;
import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.common.exception.BizExceptionEnum;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.common.exception.InvalidKaptchaException;
import com.missiongroup.starring.common.exception.NotAssignRolesException;
import com.missiongroup.starring.core.base.controller.BaseController;
import com.missiongroup.starring.core.log.LogManager;
import com.missiongroup.starring.core.log.factory.LogTaskFactory;
import com.missiongroup.starring.core.shiro.ShiroKit;
import com.missiongroup.starring.core.shiro.ShiroUser;
import com.missiongroup.starring.core.support.HttpKit;
import com.missiongroup.starring.core.util.ApiMenuFilter;
import com.missiongroup.starring.modular.system.domain.Menu;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.domain.dto.MenuDto;
import com.missiongroup.starring.modular.system.domain.dto.warpper.MenuWarpper;
import com.missiongroup.starring.modular.system.service.LoginLogService;
import com.missiongroup.starring.modular.system.service.MenuService;
import com.missiongroup.starring.modular.system.service.RoleService;
import com.missiongroup.starring.modular.system.service.UserService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * @ClassName: LoginController
 * @Description: 系统登录模块控制器
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:23:17
 *
 */
@SuppressWarnings("all")
@Api(value = "系统登录接口详情", description = "系统登录接口详情")

@Controller
public class LoginController extends BaseController {
	public static final Logger LOGGER = Logger.getLogger(LoginController.class);

//	HashMap<String, Integer> ipCount = new HashMap<>();

	@Autowired
	MenuService menuService;

	@Autowired
	UserService userService;

	@Autowired
	LoginLogService loginLogService;

	@Autowired
	RoleService roleService;

	@ApiOperation(value = "获取当前登录用户信息", notes = "获取当前登录用户信息")
	@RequestMapping(value = "/getLoginUserInfo", method = RequestMethod.GET)
	@ResponseBody
	public Object getLoginUserInfo() {
		// 获取角色列表
		List<String> roleList = ShiroKit.getUser().getRoleList();

		List<Menu> menus = menuService.getMenusByRoleIds(roleList);
		List<String> btns = menuService.getBtnsByRoleIds(roleList);

		List<MenuDto> menuDtos = (List<MenuDto>) new MenuWarpper(menus).warp();
		List<MenuDto> titles = MenuDto.buildTitle(menuDtos);
		titles = ApiMenuFilter.build(titles);

		String id = ShiroKit.getUser().getId();
		Map<String, String> user = userService.findUserInfoByUuid(id);
		user.put("roleName", ConstantFactory.me().getRoleNames((String) user.get("roleIds")));
		Map<String, Object> map = new HashMap<String, Object>();

		// 获取用户第几次登录系统
		String lastLoginTime = loginLogService.findLastLoginTime(id);
		map.put("menus", titles);
		map.put("btns", btns);
		map.put("userInfo", user);
		map.put("lastLoginTime", lastLoginTime);
		return map;
	}
	@ApiOperation(value = "跳转到登录页面", notes = "跳转到登录页面")
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public Object login(Model model) {
		Map<String, String> result = new HashMap<String, String>();
		return "/index.html";
	}

	@ApiOperation(value = "跳转到登录页面", notes = "跳转到登录页面")
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public Object index(Model model) {
		Map<String, String> result = new HashMap<String, String>();
		return "/index.html";
	}

	@ApiOperation(value = "跳转到安卓页面", notes = "跳转到安卓页面")
	@RequestMapping(value = "/android", method = RequestMethod.GET)
	public Object android(Model model) {
		Map<String, String> result = new HashMap<String, String>();
		return "/android.html";
	}

	@ApiOperation(value = "用户登录", notes = "用户登录")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "username", value = "登录账号/邮箱", required = true, paramType = "String"), //
			@ApiImplicitParam(name = "password", value = "登录密码", required = true, paramType = "String"), //
			@ApiImplicitParam(name = "kaptcha", value = "验证码", required = false, paramType = "String")//
	})
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public Object loginValidate() {

		String username = super.getPara("username");
		String password = super.getPara("password");

//		System.out.println("23434   "+password);
		String kaptcha = super.getPara("kaptcha");
		// 验证验证码是否正确
		// if (starringProperties.getKaptchaOpen() && needKaptcha()) {
		// String code = (String)
		// super.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		// if (!kaptcha.equalsIgnoreCase(code)) {
		// throw new InvalidKaptchaException(BizExceptionEnum.INVALID_KAPTCHA);
		// }
		// }

		System.out.println("dsfgdsfgdfgb1");
		Subject currentUser = ShiroKit.getSubject();

		System.out.println("dsfgdsfgdfgb2");

		UsernamePasswordToken token = new UsernamePasswordToken(username, password.toCharArray());
		System.out.println("dsfgdsfgdfgb3");


		currentUser.login(token);
		System.out.println("dsfgdsfgdfgb8");
		ShiroUser shiroUser = ShiroKit.getUser();
		System.out.println("dsfgdsfgdfgb6");
		super.getSession().setAttribute("shiroUser", shiroUser);
		System.out.println("dsfgdsfgdfgb7");
		super.getSession().setAttribute("username", shiroUser.getAccount());

		System.out.println("dsfgdsfgdfgb4");

		ShiroKit.getSession().setAttribute("sessionFlag", true);

		System.out.println("dsfgdsfgdfgb5");

		// 获取角色列表
		List<String> roleList = ShiroKit.getUser().getRoleList();
		boolean roleIsNull = false;
		for (String roleId : roleList) {
			System.out.println("234324"+roleId);
			roleIsNull = roleService.findOneByUuid(roleId) == null ? true : false;
		}

		// 判断该用户的角色是否存在
		if (roleList == null || roleList.size() == 0 || roleIsNull) {
			ShiroKit.getSubject().logout();
			System.out.println("yonghujuesebucunzai");
			throw new NotAssignRolesException(BizExceptionEnum.USER_NO_ROLE);
		}


		// LogManager.me().executeLog(LogTaskFactory.loginLog(shiroUser.getId(),
		// getIp()));
		String ip = HttpKit.getLocalIp();
		System.out.println("&&&&&&&&&"+ip);
		shiroUser.setIp(ip);
//		ipCount.put(ip, ipCount.getOrDefault(ip,0) + 1);
//		System.out.println("rrrrrrrrrrr^" + ipCount.get(ip));
//		//判断是否超过五个
//		if (ipCount.get(ip) > 500) {
//
//			ShiroKit.getSubject().logout();
//			System.out.println("yonghujuesebucunzai");
//			throw new NotAssignRolesException(BizExceptionEnum.USER_NO_ROLE);
//		}
		//new Thread(new LoginLogThread(ip, ShiroKit.getUser().getId(), 0)).start();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("token", currentUser.getSession().getId());
		result.put("shiroUser", shiroUser);
		result.put("message", "登录成功");
		return result;
	}
	
	@ApiOperation(value = "修改当前用户的密码", notes = "修改当前用户的密码")
	@ApiImplicitParams({ //
			@ApiImplicitParam(name = "oldPwd", value = "原密码", required = true, dataType = "String"), //
			@ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "String") //
	})
	@BussinessLog(value = "修改当前用户的密码")
	@RequestMapping(value = "/editLoginUserPassword", method = RequestMethod.PUT)
	@ResponseBody
	public Object editPassword(@RequestParam String oldPwd, @RequestParam String newPwd) {
		String userId = ShiroKit.getUser().getId();
		User user = userService.findOneByUuid(userId);
		String oldMd5 = ShiroKit.md5(oldPwd, user.getSalt());
		if (user.getPassword().equals(oldMd5)) {
			String newMd5 = ShiroKit.md5(newPwd, user.getSalt());
			user.setPassword(newMd5);
			user.setUpdateTime(new Date());
			user.setUpdateUserId(ShiroKit.getUser().getId());
			userService.save(user);
			return SUCCESS_TIP;
		} else {
			throw new BussinessException(BizExceptionEnum.OLD_PWD_NOT_RIGHT);
		}
	}

//	@ApiOperation(value = "注销登录", notes = "注销登录")
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logOut() {
//		LogManager.me().executeLog(LogTaskFactory.exitLog(ShiroKit.getUser().getId(), getIp()));
//		ShiroKit.getSubject().logout();
//		return REDIRECT + "/login";
//	}
	@ApiOperation(value = "注销登录", notes = "注销登录")
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public Object logOut() {
//		System.out.println("4444$$$$$$$$$$$$");
		String ip = HttpKit.getLocalIp();
//		ipCount.put(ip, ipCount.get(ip) - 1);
		//new Thread(new LoginLogThread(ip, ShiroKit.getUser().getId(), 1)).start();
		ShiroKit.getSubject().logout();
		Map<String, String> result = new HashMap<String, String>();
		result.put("code", "442");
		result.put("message", "已退出登录");


//		accoutCount.put(username, accoutCount.getOrDefault(username,0) - 1);
		return result;
	}

	private boolean needKaptcha() {
		Integer loginNum = (Integer) super.getSession().getAttribute("loginNum");
		if (loginNum == null) {
			return false;
		}
		return loginNum >= 3;
	}
}
