package com.missiongroup.starring.common.constant.dictmap.vhis.metro;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: StationDict
 * @Description: 车站管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class StationDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "vhis车站ID");
		put("ids", "vhis车站ID列表");
		put("stationId", "站点ID");
		put("stationName", "站点名称");
		put("stationNameEn", "车站英文名称");
		put("stationNameSpell", "车站名称简拼");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
