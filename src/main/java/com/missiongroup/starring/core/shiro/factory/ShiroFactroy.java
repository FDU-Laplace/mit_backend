package com.missiongroup.starring.core.shiro.factory;

import java.util.ArrayList;
import java.util.List;

import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.common.constant.state.ManagerStatus;
import com.missiongroup.starring.core.shiro.ShiroUser;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.User;
import com.missiongroup.starring.modular.system.service.RelationService;
import com.missiongroup.starring.modular.system.service.UserService;

@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactroy implements IShiro {
	@Autowired
	private UserService userService;

	@Autowired
	private RelationService relationService;

	public static IShiro me() {
		return SpringContextHolder.getBean(IShiro.class);
	}

	@Override
	public User user(String account) {
		User user = userService.findOneByAccount(account);
		// 账号不存在
		if (null == user) {
			throw new CredentialsException();
		}
		// 账号被冻结
		if (user.getStatus() != ManagerStatus.OK.getCode()) {
			throw new LockedAccountException();
		}
		return user;
	}

	@Override
	public ShiroUser shiroUser(User user) {
		ShiroUser shiroUser = new ShiroUser();

		shiroUser.setId(user.getUuid()); // 账号id
		shiroUser.setAccount(user.getAccount());// 账号
		//shiroUser.setDepartId(user.getDepartId()); // 部门id
		shiroUser.setDepartName(ConstantFactory.me().getDepartName(user.getDepartId()));// 部门名称
		shiroUser.setName(user.getName()); // 用户名称
		String[] roleArray = new String[0];
		if (ToolUtil.isNotEmpty(user.getRoleIds())) {
			roleArray = user.getRoleIds().split(",");// 角色集合
		}
		List<String> roleList = new ArrayList<String>();
		List<String> roleNameList = new ArrayList<String>();
		for (String roleId : roleArray) {
			roleList.add(roleId);
			roleNameList.add(ConstantFactory.me().getSingleRoleName(roleId));
		}
		shiroUser.setRoleList(roleList);
		shiroUser.setRoleNames(roleNameList);

		return shiroUser;
	}

	@Override
	public List<String> findPermissionsByRoleId(String roleId) {
		List<String> resUrls = relationService.getResUrlsByRoleId(roleId);
		resUrls.add("/pages/welcome");
		resUrls.add("/pages/page_debug");
		return resUrls;
	}

	@Override
	public String findRoleNameByRoleId(String roleId) {
		return ConstantFactory.me().getSingleRoleTip(roleId);
	}

	@Override
	public SimpleAuthenticationInfo info(ShiroUser shiroUser, User user, String realmName) {
		String credentials = user.getPassword();
		// 密码加盐处理
		String source = user.getSalt();
		ByteSource credentialsSalt = new Md5Hash(source);
		return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
	}
}
