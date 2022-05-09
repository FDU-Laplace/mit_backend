package com.missiongroup.starring.common.constant.dictmap.vhis.alert;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: AlertRuleDict
 * @Description: 预警规则字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class AlertRuleDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "预警规则ID");
		put("ids", "预警规则ID列表");
		put("ruleCode", "规则ID");
		put("ruleName", "规则名称");
		put("ruleValue", "规则参数JSON");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
