package com.missiongroup.starring.core.nettyserver.utils;

import java.util.Arrays;
import java.util.Map;

import com.missiongroup.starring.core.cache.service.PortModel;
import com.missiongroup.starring.core.nettyserver.entity.IOMessage;

public class HexUtil {

	private static int len = 4;

	private static String padLeft(String s, int length) {
		byte[] bs = new byte[length];
		byte[] ss = s.getBytes();
		Arrays.fill(bs, (byte) (48 & 0xff));
		System.arraycopy(ss, 0, bs, length - ss.length, ss.length);
		return new String(bs);
	}

	public static String IntegertoHexString(int var, int length) {
		return padLeft(Integer.toHexString(var), len * length);
	}

	public static String LongtoHexString(Long var, int length) {
		return padLeft(Long.toHexString(var), len * length);
	}

	/**
	 * 字节转十六进制
	 * 
	 * @param b 需要进行转换的byte字节
	 * @return 转换后的Hex字符串
	 */
	public static String byteToHex(byte b) {
		String hex = Integer.toHexString(b & 0xFF);
		if (hex.length() < 2) {
			hex = "0" + hex;
		}
		return padLeft(hex,len);
	}
	
	/**
	 * Bit 字符串转Byte
	 */
	public static byte BitToByte(String byteStr) {
	 int re, len;
	 if (null == byteStr) {
	  return 0;
	 }
	 len = byteStr.length();
	 if (len != 4 && len != 8) {
	  return 0;
	 }
	 if (len == 8) {// 8 bit处理
	  if (byteStr.charAt(0) == '0') {// 正数
	   re = Integer.parseInt(byteStr, 2);
	  } else {// 负数
	   re = Integer.parseInt(byteStr, 2) - 256;
	  }
	 } else {//4 bit处理
	  re = Integer.parseInt(byteStr, 2);
	 }
	 return (byte) re;
	}
	
	
	public static String getBitString(IOMessage ioMessage, String portData,String[] strArray) {
		StringBuffer sbf = new StringBuffer();
		for (String array : strArray) {
			Map<String, PortModel> portModelMap = (Map<String, PortModel>) ioMessage.getPortDatas().get(portData);
			for (Map.Entry<String, PortModel> entryPortModelMap : portModelMap.entrySet()) {
				if (entryPortModelMap.getKey().endsWith(array)) {
					sbf.append(entryPortModelMap.getValue().getValue());
					//return HexUtil.LongtoHexString(entryPortModelMap.getValue().getValue(), length);
				}
			}
		}
		return sbf.toString();
	}
	
	/**
	 * 字符串左右补0
	 * 
	 * @param flag true左补0  false右补0
	 * @param strLength 长度
	 * @return 转换后的Hex字符串
	 */
	public static String addZeroForNum(String str, int strLength,Boolean flag) {
	    int strLen = str.length();
	    if (strLen < strLength) {
	        while (strLen < strLength) {
	            StringBuffer sb = new StringBuffer();
	            if(flag) {
	            	sb.append("0").append(str);//左补0
	            }else {
	            	sb.append(str).append("0");//右补0
	            }
	            str = sb.toString();
	            strLen = str.length();
	        }
	    }
	    return str;
	}
}
