package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: RoleDict
 * @Description: 角色的字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午2:35:21
 *
 */
public class RoleDict extends AbstractDictMap {
	@Override
	public void init() {
		put("roleId", "角色名称");
		put("roleIds", "角色名称");
		put("sort", "角色排序");
		put("name", "角色名称");
		put("departId", "部门");
		put("remark", "备注");
		put("ids", "资源名称");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("departId", "getDepartName");
		putFieldWrapperMethodName("roleIds", "getRoleNames");
		putFieldWrapperMethodName("roleId", "getSingleRoleName");
		putFieldWrapperMethodName("ids", "getMenuNames");
	}
}
