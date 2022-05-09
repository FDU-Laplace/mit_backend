package com.missiongroup.starring.common.constant.dictmap;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: DepartDict
 * @Description: 部门的映射
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午2:14:26
 *
 */
public class DepartDict extends AbstractDictMap {
	@Override
	public void init() {
		put("departId", "部门");
		put("sort", "部门排序");
		put("parentId", "上级部门");
		put("name", "部门名称");
		put("departIds", "部门列表");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("departId", "getDepartName");
		putFieldWrapperMethodName("parentId", "getDepartName");
		putFieldWrapperMethodName("departIds", "getDepartName");
	}
}
