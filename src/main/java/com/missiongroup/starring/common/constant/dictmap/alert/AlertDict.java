package com.missiongroup.starring.common.constant.dictmap.alert;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: AlertDict
 * @Description: 预警字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class AlertDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "预警ID");
		put("ids", "预警ID列表");
		put("alertCode", "预警Code");
		put("relationLin", "关联线路ID");
		put("relationTrain", "关联列车ID");
		put("alertSys", "预警系统");
		put("relationRule", "关联规则ID");
		put("alertName", "预警名称");
		put("alertLevel", "预警等级");
		put("isAlert", "是否预警");
		put("pushStatus", "推送状态");
		put("alertTime", "预警时间");
		put("remarks", "备注");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
