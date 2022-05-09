package com.missiongroup.starring.common.constant.dictmap.vhis.device;

import com.missiongroup.starring.common.constant.dictmap.base.AbstractDictMap;

/**
 * 
 * @ClassName: LineDict
 * @Description: 线路的字典
 * @author YAOWEI
 * @date 2018年4月24日 下午2:35:21
 *
 */
public class DeviceControlDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "设备名称");
		put("deviceIds", "设备列表");
		put("parentDeviceIds", "播控列表");
		put("cmd","指令类型");
		put("volume","音量");
		put("type","类型");
		put("openDeviceTime","开机时间");
		put("closeDeviceTime","关机时间");
		put("openScreenTime","开屏时间");
		put("closeScreenTime","关屏时间");
		put("volume","音量");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("deviceIds", "getDeviceName");
		putFieldWrapperMethodName("parentDeviceIds", "getDeviceName");
	}
}
