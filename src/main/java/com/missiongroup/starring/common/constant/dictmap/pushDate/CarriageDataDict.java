package com.missiongroup.starring.common.constant.dictmap.pushDate;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: CarriageDataDict
 * @Description: 车厢数据字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class CarriageDataDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "车厢数据ID");
		put("ids", "车厢数据ID列表");
		put("ts_timestamp", "时间");
		put("carriageId", "车厢id");
		put("carriageNum", "车厢编号");
		put("trianId", "车辆id");
		put("lineId", "线路ID");
		put("dricab_activate", "司机室激活端");
		put("dricab_wall_door", "司机室壁门");
		put("dricab_escape_door", "司机室逃生门");
		put("riding_rate", "乘车率");
		put("brake_state", "制动状态");
		put("compartment_temperature", "客室温度");
		put("humidity", "湿度");
		put("traction", "牵引力30%");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
