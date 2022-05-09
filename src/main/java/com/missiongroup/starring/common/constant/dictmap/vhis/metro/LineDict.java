package com.missiongroup.starring.common.constant.dictmap.vhis.metro;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: LineDict
 * @Description: 线路管理字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class LineDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "vhis线路ID");
		put("ids", "vhis线路ID列表");
		put("lineId", "线路ID");
		put("lineType", "线路类型");
		put("lineColor", "线路颜色");
		put("lineName", "线路名称");
		put("lineNameEn", "英文名称");
		put("lineNum", "线路编号");
		put("lineCode", "线路简码");
		put("isRun", "是否开通");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
