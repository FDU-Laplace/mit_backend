package com.missiongroup.starring.common.constant.dictmap.vhis.analysis;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: TrainEarlyWarningDict
 * @Description: 列车预警管理字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class TrainEarlyWarningDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "列车预警ID");
		put("ids", "列车预警ID列表");
		put("num", "列号");
		put("name", "预警名称");
		put("measure", "建议措施");
		put("time", "时间");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
