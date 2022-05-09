package com.missiongroup.starring.common.constant.dictmap.vhis.analysis;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: VariableAnalysisDict
 * @Description: 变量分析字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class VariableAnalysisDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "变量分析ID");
		put("ids", "变量分析ID列表");
		put("lineId", "线路ID");
		put("garageId", "车库ID");
		put("trainId", "列车ID");
		put("name", "变量名称");
		put("description", "描述");
		put("occurTime", "发生时间");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
