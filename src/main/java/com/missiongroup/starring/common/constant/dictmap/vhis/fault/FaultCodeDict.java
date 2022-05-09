package com.missiongroup.starring.common.constant.dictmap.vhis.fault;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: FaultCodeDict
 * @Description: 故障编码管理字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class FaultCodeDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "故障编码ID");
		put("ids", "故障编码ID列表");
		put("id", "ID");
		put("faultId", "故障代码");
		put("source", "来源");
		put("description", "描述");
		put("level", "等级");
		put("priority", "优先级");
		put("checkSignal", "检查信号");
		put("checkCondition", "检查环境");
		put("checkTrain", "检查车辆");
		put("disposal", "处置");
		put("remark", "备注");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
