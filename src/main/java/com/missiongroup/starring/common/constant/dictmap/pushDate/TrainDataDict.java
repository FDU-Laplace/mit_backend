package com.missiongroup.starring.common.constant.dictmap.pushDate;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: TrainDataDict
 * @Description: 列车数据字典
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class TrainDataDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "列车数据ID");
		put("ids", "列车数据ID列表");
		put("ts_timestamp", "创建时间");
		put("lineId", "线路ID");
		put("trainId", "列车ID");
		put("status", "状态 0：离线，1：在线");
		put("theoreticalReception", "理论接收");
		put("ctualReception", "实际接收");
		put("acceptanceRate", "接收率");
		put("location", "行驶位置 (0 地下1 涵洞2 地上)");
		put("trian_speed", "速度 km/h");
		put("trian_net_voltage", "网压 V");
		put("trian_wind_pressure", "主风压力 bar");
		put("trian_brake_pressure", "制动压力 bar");
		put("trian_battery_voltage", "蓄电池电压 V");
		put("trian_broadcast_mode", "报站模式(0 自动;1 手动)");
		put("trian_run_mode", "运行模式(0 惰性；)");
		put("trian_control_mode", "控制模式(0 AIO 模式 ；)");
		put("trian_unit_energy", "单位耗能 kWh/km");
		put("trian_total_energy", "总耗能 kWh");
		put("trian_current_station", "当前站");
		put("trian_next_station", "下一站");
		put("trian_terminus", "终点站");
		put("trian_RxLev", "信号强度 0：弱 1：中 2：强");
		put("trian_delivery_channel", "传输通道");
		put("trian_commissioning", "是否投运 1:是 0：否");
		put("trian_main_line", "是否正线1:是 0：否");
	}

	@Override
	protected void initBeWrapped() {
	    
	}
}
