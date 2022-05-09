package com.missiongroup.starring.core.nettyclient.entity;

/**
 *
 * @author   YAOWEI 
 * @date     2018-7-31  
 * @see      com.missiongroup.starring.core.nettyclient.entity.Command 
 */

public class Command {
	// 心跳
	public static final short HEARTBEAT_MSG = 0x0001;
	// PC开机
	public static final short PC_START_MSG = 0x0301;
	// PC重启
	public static final short PC_RESTART_MSG = 0x0302;
	// PC关机
	public static final short PC_STOP_MSG = 0x0303;
	// PC截图
	public static final short PC_INTERCEPT_MSG = 0x0304;
	// 播表下发
	public static final short PLAYLIST_PUBLISH_MSG = 0x0305;
	// 设备状态监控
	public static final short DEVICE_STATUS_MONITOR_MSG = 0x0306;
	// 设备日志
	public static final short DEVICE_LOG_MSG = 0x0307;
	// 任务发布
	public static final short TASK_MSG = 0x0305;
	// 直播下发
	public static final short LIVE_SOURCE_MSG = 0x0305;
	// 定时开关机
	public static final short PC_TIMINGBOOT_MSG = 0x0310;
	// 取消定时开关机
	public static final short PC_CANCELTIMINGBOOT_MSG = 0x0311;
	// 设置运营时间
	public static final short PC_SCHEDULE_MSG = 0x0312;
	// LCD开屏
	public static final short LCD_SCREENON_MSG = 0x0401;
	// LCD关屏
	public static final short LCD_SCREENOFF_MSG = 0x0402;
	// LCD音量
	public static final short LCD_VOLUME_MSG = 0x0403;
	// LCD静音
	public static final short LCD_MUTE_MSG = 0x0404;
	// LCD静音恢复
	public static final short LCD_UNMUTE_MSG = 0x0405;
	// 信息发布
	public static final short  PASSENGER_MSG = 0x0406;
	// 安全模式
	public static final short SAFE_MODE_MSG = 0x0406;
	// LED定时开关屏
	public static final short LED_TIMINGSWITCHSCREEN_MSG = 0x0407;
	// LCD定时开关屏
	public static final short LCD_TIMINGSWITCHSCREEN_MSG = 0x0407;
	// LED取消定时开关屏
	public static final short LED_CANCELTIMINGSWITCHSCREEN_MSG = 0x0407;
	// LCD取消定时开关屏
	public static final short LCD_CANCELTIMINGSWITCHSCREEN_MSG = 0x0407;
	// LED开屏
	public static final short LED_SCREENON_MSG = 0x0501;
	// LED关屏
	public static final short LED_SCREENOFF_MSG = 0x0502;
	// LED信息发布
	public static final short LED_INFO_MSG = 0x0503;
}

