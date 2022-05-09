package com.missiongroup.starring.core.nettyserver.entity;

import java.util.concurrent.CountDownLatch;

public class Constants {
	/**
	 * 平台jboss临时目录，用于存储一体机的截图
	 */
	public static String platformTempPath;

	/**
	 * 乐观锁
	 */
	public static CountDownLatch latch;

	/**
	 * tcp 端口
	 */
	public final static int Port = 30100;

	/**
	 * ftp路径
	 */
	public final static String ftpRootPath = "/file_server_root/";

	//协议版本号
	public static final short PROTOCOL_VERSION = 1;
	//头部的长度： 版本号 + 报文长度
	public static final short PROTOCOL_HEADLENGTH = 4;
	//长度的偏移
	public static final short LENGTH_OFFSET = 10;
	//长度的字节数
	public static final short LENGTH_BYTES_COUNT = 4;
}