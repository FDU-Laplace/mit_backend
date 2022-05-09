package com.missiongroup.starring.common.constant.dictmap.vhis.fault;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: FaultDict
 * @Description: 故障字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class FaultConfigDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "故障ID");
		put("ids", "故障ID列表");
		put("faultCode", "故障代码");
		put("faultName", "故障名称");
		put("faultLevel", "故障等级");
		put("describe", "故障描述");
		put("disposal", "处理方式");

	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
