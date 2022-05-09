package com.missiongroup.starring.common.constant.dictmap.vhis.metro;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: TrainDict
 * @Description: 列车管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class TrainDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "vhis列车ID");
		put("ids", "vhis列车ID列表");
		put("relationLine", "关联线路ID");
		put("trainId", "列车ID");
		put("trainType", "列车类型");
		put("trainName", "列车名册");
		put("trainCode", "列车编码");
		put("remark", "列车备注");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
