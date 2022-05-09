package com.missiongroup.starring.common.constant.dictmap.vhis.fault;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: FaultInfoDict
 * @Description: 故障信息查询字典
 * @author TAIHUAYUN
 * @date 2018年4月9日 下午3:13:41
 *
 */
public class FaultInfoDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "故障信息ID");
		put("ids", "故障信息ID列表");
		put("garageId", "车库ID");
		put("faultId", "故障ID");
		put("occurTime", "发生时间");
		put("receiveTime", "接收时间");
		put("occurLocation", "发生地点");
		put("occurRecoverType", "发生回复类型");
		put("lineId", "线路ID");
		put("trainId", "列车ID");
		put("tractionBrakeLevel", "牵引制动等级");
		put("trainBrakeType", "列车制动类型");
		put("speed", "速度");
		put("direction", "方向");
		put("previousStationId", "前一个车站ID");
		put("nextStationId", "下一个车站ID");
		put("remark", "备注");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
