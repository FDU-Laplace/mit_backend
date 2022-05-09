package com.missiongroup.starring.core.nettyserver.utils;

import java.io.UnsupportedEncodingException;

public class ByteUtil {
	private static String CHAR_ENCODE = "UTF-8";

	public static byte[] stringToByte(String str) {
		return stringToByte(str, CHAR_ENCODE);
	}

	public static String byteToString(byte[] byteArray) {
		return byteToString(byteArray, CHAR_ENCODE);
	}

	public static byte[] stringToByte(String str, String charEncode) {
		byte[] destObj = null;
		try {
			if (null != str && str.length() > 0) {
				destObj = str.getBytes(charEncode);
			} else {
				destObj = new byte[0];
				return destObj;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return destObj;
	}

	public static String byteToString(byte[] byteArray, String charEncode) {
		String destObj = null;
		try {
			destObj = new String(byteArray, charEncode);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return destObj.replaceAll("\0", " ");
	}

	public static byte[] intToBytes4(int num) {
		byte[] b = new byte[4];
		for (int i = 0; i < 4; i++) {
			b[i] = ByteUtil.itob((num >> (24 - i * 8)));
		}
		return b;
	}

	public static byte[] shortToBytes2(short num) {
		byte[] b = new byte[2];
		for (int i = 0; i < 2; i++) {
			b[i] = (byte) (num >> (8 - i * 8));
		}
		return b;
	}

	public static int byte4ToInt21(byte[] b) {
		return ((ByteUtil.btoi(b[3]) << 24) + (ByteUtil.btoi(b[2]) << 16) + (ByteUtil.btoi(b[1]) << 8) + ByteUtil.btoi(b[0]));
	}

	public static int byteToInt22(byte[] b) {
		return ((ByteUtil.btoi(b[0]) << 24) + (ByteUtil.btoi(b[1]) << 16) + (ByteUtil.btoi(b[2]) << 8) + ByteUtil.btoi(b[3]));
	}

	public static int byteToShort(byte[] b) {
		return (ByteUtil.btoi(b[1]) << 8) + ByteUtil.btoi(b[0]);
	}

	public static int byteToShort2(byte[] b) {
		return (ByteUtil.btoi(b[0]) << 8) + ByteUtil.btoi(b[1]);
	}

	public static byte itob(int number) {
		return (byte) (number & 0xff);
	}

	public static int btoi(byte bt) {
		return bt & 0xff;
	}

	public static int[] byteArrayToIntAray(byte[] byteArray) {
		int intArray[] = new int[byteArray.length];
		for (int i = 0; i < byteArray.length; i++) {
			intArray[i] = byteArray[i] & 0xff;
		}
		return intArray;
	}

	public static String getDataInfo(byte[] data) {
		int intArray[] = ByteUtil.byteArrayToIntAray(data);
		StringBuffer dataInfo = new StringBuffer();
		for (int j = 0; j < intArray.length; j++) {
			if (intArray[j] <= 15) {
				dataInfo.append("0");
			}
			dataInfo.append(Integer.toHexString(intArray[j])).append(" ");
		}
		return dataInfo.toString();
	}

	public static byte[] int32TobyteArray(long num) {
		byte[] targets = new byte[4];
		targets[0] = (byte) (num & 0xff);
		targets[1] = (byte) ((num >> 8) & 0xff);
		targets[2] = (byte) ((num >> 16) & 0xff);
		targets[3] = (byte) (num >>> 24);
		return targets;
	}

	public static byte[] int16TobyteArray(int num) {
		byte[] targets = new byte[2];
		targets[0] = (byte) (num & 0xff);
		targets[1] = (byte) ((num >> 8) & 0xff);
		return targets;
	}

	public static byte[] int16TobyteArray2(int num) {
		byte[] targets = new byte[2];
		targets[0] = (byte) (num >> 8 & 0xff);
		targets[1] = (byte) (num & 0xff);
		return targets;
	}

	public static byte[] longToBytes(long num) {
		byte[] targets = new byte[4];
		targets[0] = (byte) ((num >> 24) & 0xff);
		targets[1] = (byte) ((num >> 16) & 0xff);
		targets[2] = (byte) ((num >> 8) & 0xff);
		targets[3] = (byte) (num & 0xff);
		return targets;
	}

	public static long byte4ToLong(byte[] b) {
		return (ByteUtil.btoi(b[0]) << 24) + (ByteUtil.btoi(b[1]) << 16) + (ByteUtil.btoi(b[2]) << 8) + ByteUtil.btoi(b[3]);
	}

	public static String bcd2Str(byte[] bytes) {
		StringBuffer temp = new StringBuffer(bytes.length * 2);
		for (int i = 0; i < bytes.length; i++) {
			temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
			temp.append((byte) (bytes[i] & 0x0f));
		}
		return temp.toString();
	}

	public static byte[] str2Bcd(String asc) {
		int len = asc.length();
		int mod = len % 2;
		if (mod != 0) {
			asc = "0" + asc;
			len = asc.length();
		}
		byte abt[] = new byte[len];
		if (len >= 2) {
			len = len / 2;
		}
		byte bbt[] = new byte[len];
		abt = asc.getBytes();
		int j, k;
		for (int p = 0; p < asc.length() / 2; p++) {
			if ((abt[2 * p] >= '0') && (abt[2 * p] <= '9')) {
				j = abt[2 * p] - '0';
			} else if ((abt[2 * p] >= 'a') && (abt[2 * p] <= 'z')) {
				j = abt[2 * p] - 'a' + 0x0a;
			} else {
				j = abt[2 * p] - 'A' + 0x0a;
			}
			if ((abt[2 * p + 1] >= '0') && (abt[2 * p + 1] <= '9')) {
				k = abt[2 * p + 1] - '0';
			} else if ((abt[2 * p + 1] >= 'a') && (abt[2 * p + 1] <= 'z')) {
				k = abt[2 * p + 1] - 'a' + 0x0a;
			} else {
				k = abt[2 * p + 1] - 'A' + 0x0a;
			}
			int a = (j << 4) + k;
			byte b = (byte) a;
			bbt[p] = b;
		}
		return bbt;
	}

	/**
	 * 二进制数据转换为十六进制格式字符串
	 *
	 * @param byteArray 二进制数据
	 * @return 十六进制格式字符串
	 */
	public static String byteArrayToHexStr(byte[] byteArray) {
		if (byteArray == null) {
			return null;
		}
		char[] hexArray = "0123456789ABCDEF".toCharArray();
		char[] hexChars = new char[byteArray.length * 2];
		for (int j = 0; j < byteArray.length; j++) {
			int v = byteArray[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[j * 2 + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}
}