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
public class FaultDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "故障ID");
		put("ids", "故障ID列表");
		put("relationLin", "线路ID");
		put("relationTrain", "列车ID");
		put("relationCarriage", "车厢ID");
		put("faultSys", "故障系统");
		put("faultCode", "故障代码");
		put("faultName", "故障名称");
		put("faultLevel", "故障等级");
		put("isFault", "是否故障");
		put("confirmFault", "故障确认");
		put("occurrenceTime", "发生时间");
		put("confirmTime", "确认时间");
		put("remarks", "备注");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
