package com.missiongroup.starring.common.constant.dictmap.vhis.monitor;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: CurrentErrorDict
 * @Description: 当前故障管理字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class CurrentErrorDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "当前故障ID");
		put("ids", "当前故障ID列表");
		put("num", "列号");
		put("trainCode", "列车代码");
		put("code", "故障代码");
		put("name", "故障名称");
		put("time", "故障时间");
		put("system", "故障系统");
		put("level", "等级");
		put("state", "状态");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
