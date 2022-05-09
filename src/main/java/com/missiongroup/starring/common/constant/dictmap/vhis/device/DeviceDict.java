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
public class DeviceDict extends AbstractDictMap {
	@Override
	public void init() {
		put("uuid", "设备名称");
		put("deviceIds", "设备列表");
		put("deviceTypeId", "设备类型");
		put("name", "设备名称");
		put("lineId", "线路名称");
		put("stationId", "车站名称");
		put("parentId", "上级设备");
		put("ip", "设备IP");
		put("port", "端口号");
		put("pduIp", "PDUIP");
		put("pduPort", "PDUPORT");
		put("screenNo", "屏号");
		put("resolution", "分辨率");
		put("os", "操作系统");
		put("mac", "MAC");
		put("areaId", "区域");
		put("groupId","分组");
		put("com","控制口");
		put("openDeviceTime","开机时间");
		put("closeDeviceTime","关机时间");
		put("openScreenTime","开屏时间");
		put("closeScreenTime","关屏时间");
		put("volume","音量");
		put("company","厂商");
		put("remark","备注");
	}

	@Override
	protected void initBeWrapped() {
		putFieldWrapperMethodName("lineId", "getLineName");
		putFieldWrapperMethodName("stationId", "getStationName");
		putFieldWrapperMethodName("uuid", "getDeviceName");
		putFieldWrapperMethodName("ids", "getDeviceName");
		putFieldWrapperMethodName("deviceIds", "getDeviceName");
		putFieldWrapperMethodName("parentId", "getDeviceName");
		putFieldWrapperMethodName("deviceTypeId", "getDeviceTypeName");
		putFieldWrapperMethodName("areaId", "getAreaNameById");
		putFieldWrapperMethodName("groupId", "getGroupNameById");
	}
}
