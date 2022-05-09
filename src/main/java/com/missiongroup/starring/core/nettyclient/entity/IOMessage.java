package com.missiongroup.starring.core.nettyclient.entity;

import java.io.UnsupportedEncodingException;
import java.util.LinkedList;

import org.apache.log4j.Logger;

import com.missiongroup.starring.core.nettyclient.util.MD5Util;
import com.missiongroup.starring.core.nettyclient.util.Utils;

public class IOMessage {

	/**
	 * 消息类型码 WORD 2位
	 */
	private short operaCode;
	/**
	 * 会话流水号 请求消息：发起方分配的，唯一标识本会话的流水号,应答消息：内容与请求消息相同 LONG 4位
	 */
	private int uuid;
	/**
	 * 请求/应答标志 0x00：请求消息；0x01：应答消息 BYTE 1位
	 */
	private int flag;
	/**
	 * 路径长度 长字，长度：4个字节，采用大端(Big Endian)的编码方式 Long 4位
	 */
	private int pathLength;
	/**
	 * 路径 Xml路径数据定义 Block 可变
	 */
	private String path;
	/**
	 * 消息报文版本 缺省为0x01 BTYE 1位
	 */
	private int version;
	/**
	 * 应答码 对于请求消息，默认为0； 应答消息填应答码 00:成功 01:报文格式错误 02:重复应答 03:目标结点不可达 04:通讯超时
	 * 00表示收到并已处理成功，非00表示失败
	 */
	private int responseCode;
	/**
	 * 包长度 4位
	 */
	private int packageLength;
	/**
	 * 包体内容
	 */
	private String packageContent;
	/**
	 * 校验码 验证内容包括包头和包体，算法为MD5
	 */
	private String MD5;
	
	private static final Logger logger = Logger.getLogger(IOMessage.class);
	
	public IOMessage(){
		
	}
	
	public IOMessage(short operaCode, String path, String packageContent) {
		try {
			this.path = path;
			this.pathLength = path.getBytes("UTF-8").length;
			this.flag = 0x00;
			this.version = 0x01;
			this.operaCode = operaCode;
			this.responseCode = 0;
			this.uuid = Utils.getUniqueID();
			this.packageContent = packageContent;
			this.packageLength = 13 + path.getBytes("UTF-8").length + packageContent.getBytes("UTF-8").length + 16;
			this.MD5 = generateMD5();
		} catch (Exception e) {
			logger.info(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * 获取md5加密校验码
	 * 
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public String generateMD5() throws UnsupportedEncodingException {
		String md5 = null;
		// 消息类型码
		byte[] operaCode_byte = Utils.shortToByte(operaCode);
		// 会话流水号
		byte[] uuid_byte = Utils.intToByte(uuid, 4);
		// 请求/应答标志
		byte[] flag_byte = Utils.intToByte(flag, 1);
		// 路径长度
		byte[] pathLength_byte = Utils.intToByte(pathLength, 4);
		// 路径
		byte[] path_byte = path.getBytes("UTF-8");
		// 消息报文版本
		byte[] version_byte = Utils.intToByte(version, 1);
		// 应答码
		byte[] responseCode_byte = Utils.intToByte(responseCode, 1);
		// 包体内容
		byte[] packageContent_byte = packageContent.getBytes("UTF-8");
		LinkedList<byte[]> result = new LinkedList<byte[]>();
		result.add(operaCode_byte);
		result.add(uuid_byte);
		result.add(flag_byte);
		result.add(pathLength_byte);
		result.add(path_byte);
		result.add(version_byte);
		result.add(responseCode_byte);
		result.add(packageContent_byte);
		Utils.byteMerger(result);
		md5 = MD5Util.createMD5(result.get(0));
		return md5;
	}

	public short getOperaCode() {
		return operaCode;
	}

	public int getUuid() {
		return uuid;
	}

	public int getFlag() {
		return flag;
	}

	public int getPathLength() {
		return pathLength;
	}

	public String getPath() {
		return path;
	}

	public int getVersion() {
		return version;
	}

	public int getResponseCode() {
		return responseCode;
	}

	public int getPackageLength() {
		return packageLength;
	}

	public String getPackageContent() {
		return packageContent;
	}

	public String getMD5() {
		return MD5;
	}

	public void setOperaCode(short operaCode) {
		this.operaCode = operaCode;
	}

	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public void setPathLength(int pathLength) {
		this.pathLength = pathLength;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public void setPackageLength(int packageLength) {
		this.packageLength = packageLength;
	}

	public void setPackageContent(String packageContent) {
		this.packageContent = packageContent;
	}

	public void setMD5(String mD5) {
		MD5 = mD5;
	}

}
