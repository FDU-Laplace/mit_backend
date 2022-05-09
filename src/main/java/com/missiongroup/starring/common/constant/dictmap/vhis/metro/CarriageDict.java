package com.missiongroup.starring.common.constant.dictmap.vhis.metro;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: CarriageDict
 * @Description: 车厢管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "vhis车厢ID");
		put("ids", "vhis车厢ID列表");
		put("relationLine", "关联线路ID");
		put("relationTrain", "关联列车ID");
		put("carriageId", "车厢ID");
		put("carriageType", "车厢类型");
		put("carriageName", "车厢名称");
		put("carriageCode", "车厢code");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
