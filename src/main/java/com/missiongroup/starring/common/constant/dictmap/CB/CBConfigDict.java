package com.missiongroup.starring.common.constant.dictmap.CB;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: CBConfigDict
 * @Description: 断路器管理字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class CBConfigDict extends AbstractDictMap {
	@Override
	public void init() {
		put("id", "断路器名称");
		put("ids", "断路器名称列表");
		put("name", "姓名");
		put("car", "车厢");
		put("description", "描述");
	}

	@Override
	protected void initBeWrapped() {
	    putFieldWrapperMethodName("id", "");
	    putFieldWrapperMethodName("ids", "");
	}
}
