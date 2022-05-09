package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 用户的字典
 *
 * @author mission
 * @date 2017-05-06 15:01
 */
public class UserDict extends AbstractDictMap {

	@Override
	public void init() {
		put("userId", "账号");
		put("account", "账号");
		put("name", "姓名");
		put("birthday", "生日");
		put("sex", "性别");
		put("email", "电子邮件");
		put("phone", "电话");
		put("userIds", "账号");
		put("roleIds", "角色");
		put("departId", "部门");
		put("roleId", "角色");
		put("status", "用户状态");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("sex", "getSexName");
		putFieldWrapperMethodName("departId", "getDepartName");
		putFieldWrapperMethodName("roleId", "getRoleName");
		putFieldWrapperMethodName("userIds", "getUserAccountsByIds");
		putFieldWrapperMethodName("userId", "getUserAccountById");
		putFieldWrapperMethodName("roleIds", "getRoleName");
		putFieldWrapperMethodName("status", "getStatusName");
	}
}
