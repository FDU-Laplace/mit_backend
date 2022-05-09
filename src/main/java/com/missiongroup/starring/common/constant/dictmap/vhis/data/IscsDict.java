package com.missiongroup.starring.common.constant.dictmap.vhis.data;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: IscsDict
 * @Description: iscs管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class IscsDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "iscs数据ID");
		put("ids", "iscs数据ID列表");
		put("trainnum", "车辆编号");
		put("mvbdata", "数据");
		put("recordtime", "记录时间");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
