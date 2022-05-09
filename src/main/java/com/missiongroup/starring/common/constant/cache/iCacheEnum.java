package com.missiongroup.starring.common.constant.cache;

/**
 * 系统常量
 *
 * @author mission
 * @date 2017年2月12日 下午9:42:53
 */
public interface iCacheEnum {

	/**
	 * 车辆数据推送缓存名称
	 */
	String  ICACHE_WEBSOCKET_TRAIN_DATA = "icacheTrain";
	
	/**
	 * 车厢数据推送缓存名称
	 */
	String  ICACHE_WEBSOCKET_CARRIAGE_DATA = "icacheCarriage";
	
	/**
	 * 车厢数据推送缓存名称
	 */
	String  ICACHE_WEBSOCKET_LINE_DATA = "icacheLine";
	
	
	/**
	 * 时时推送数据缓存名称
	 */
	String  ICACHE_REAL_TIME_DATA = "icacheRealTime";

	
}
