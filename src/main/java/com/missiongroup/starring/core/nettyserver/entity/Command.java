package com.missiongroup.starring.core.nettyserver.entity;

public class Command {
	public static final String PING = "1000";
	public static final String CAPTURE = "1001";
	public static final String STOP = "1002";
	public static final String RESTART = "1003";
	public static final String START = "1004";
	public static final String VOLUME = "1005";
	public static final String OPENSCREEN = "1006";
	public static final String CLOSESCREEN = "1007";
	/**
	 * 信息撤销
	 */
	public static final String CANCEL_INFO_MSG = "0001";
	/**
	 * 按钮点击推送全局数据
	 */
	public static final String ALLCFG4BTN = "1008";

	/**
	 * 完整数据
	 */
	public static final String FULLCFG = "1009";

	/**
	 * 同步一体机客户端程序
	 */
	public static final String SYNCCLIENT = "1010";

	/**
	 * 首末班车时间
	 */
	public static final String OPERATIONTIME = "1100";

	/**
	 * 周边公交信息
	 */
	public static final String PERIPHERY = "1101";

	/**
	 * 向导线路图信息
	 */
	public static final String GUIDEIMG = "1102";

	/**
	 * 滚动消息
	 */
	public static final String NORMALINFO = "1103";

	/**
	 * 旅游图
	 */
	public static final String TOURIMG = "1104";

	/**
	 * 视频
	 */
	public static final String ADCOLUMN = "1105";

	/**
	 * 直播
	 */
	public static final String LIVE = "1106";

	/**
	 * 公交信息
	 */
	public static final String BUS = "1107";
	/**
	 * 紧急信息发布
	 */
	public static final String EMERGENCY_INFO_MSG = "1108";
	/**
	 * 停运信息发布
	 */
	public static final String OFFSTREAM_INFO_MSG = "1109";
	/**
	 * 停运信息发布
	 */
	public static final String TEMPORARY_INFO_MSG = "1110";
	/**
	 * 设备状态
	 */
	public static final String DEVICESTATE = "1200";
}