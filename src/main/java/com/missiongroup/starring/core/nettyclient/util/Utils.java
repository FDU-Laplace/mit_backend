package com.missiongroup.starring.core.nettyclient.util;

import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.Random;

public class Utils {
	public static byte[] byteMerger(byte[] byte_1, byte[] byte_2) {
		byte[] byte_3 = new byte[byte_1.length + byte_2.length];
		System.arraycopy(byte_1, 0, byte_3, 0, byte_1.length);
		System.arraycopy(byte_2, 0, byte_3, byte_1.length, byte_2.length);
		return byte_3;
	}

	// 以下是高八位的byte与数字互转
	public static byte[] longToBytes(long l) {
		byte b[] = new byte[8];
		b[0] = (byte) (0xff & (l >> 56));
		b[1] = (byte) (0xff & (l >> 48));
		b[2] = (byte) (0xff & (l >> 40));
		b[3] = (byte) (0xff & (l >> 32));
		b[4] = (byte) (0xff & (l >> 24));
		b[5] = (byte) (0xff & (l >> 16));
		b[6] = (byte) (0xff & (l >> 8));
		b[7] = (byte) (0xff & l);
		return b;
	}

	// 从byte数组的index处的连续8个字节获得一个long
	public static long bytesToLong(byte[] array) {
		return ((((long) array[0] & 0xff) << 56) | (((long) array[1] & 0xff) << 48) | (((long) array[2] & 0xff) << 40) | (((long) array[3] & 0xff) << 32) | (((long) array[4] & 0xff) << 24) | (((long) array[5] & 0xff) << 16) | (((long) array[6] & 0xff) << 8) | (((long) array[7] & 0xff) << 0));
	}

	public static byte[] intToByte(int i, int len) {
		byte[] abyte = null;
		if (len == 1) {
			abyte = new byte[len];
			abyte[0] = (byte) (0xff & i);
		} else {
			abyte = new byte[len];
			abyte[0] = (byte) ((i >>> 24) & 0xff);
			abyte[1] = (byte) ((i >>> 16) & 0xff);
			abyte[2] = (byte) ((i >>> 8) & 0xff);
			abyte[3] = (byte) (i & 0xff);
		}
		return abyte;
	}

	public static int bytesToInt(byte[] bytes) {
		int addr = 0;
		if (bytes.length == 1) {
			addr = bytes[0] & 0xFF;
		} else {
			addr = bytes[0] & 0xFF;
			addr = (addr << 8) | (bytes[1] & 0xff);
			addr = (addr << 8) | (bytes[2] & 0xff);
			addr = (addr << 8) | (bytes[3] & 0xff);
		}
		return addr;
	}

	public static byte[] shortToByte(short n) {

		byte[] b = new byte[2];

		b[1] = (byte) (n & 0xff);

		b[0] = (byte) ((n >> 8) & 0xff);

		return b;

	}

	public static short byteToShort(byte[] b) {

		return (short) (b[1] & 0xff

				| (b[0] & 0xff) << 8);

	}

	public static void byteMerger(LinkedList<byte[]> byteLst) {
		byte[] byte_union = new byte[byteLst.get(0).length + byteLst.get(1).length];
		System.arraycopy(byteLst.get(0), 0, byte_union, 0, byteLst.get(0).length);
		System.arraycopy(byteLst.get(1), 0, byte_union, byteLst.get(0).length, byteLst.get(1).length);
		byteLst.removeFirst();
		byteLst.removeFirst();
		byteLst.addFirst(byte_union);
		if (byteLst.size() > 1) {
			byteMerger(byteLst);
		}
	}

	public static long getRequestID() {
		long t1 = 0x7FFFFFFF & System.currentTimeMillis();
		Random random = new Random();
		return t1 << 32 | Math.abs(random.nextInt());
	}

	public static int getUniqueID() {
		long l1 = System.currentTimeMillis();
		Integer i1 = new Long(l1).intValue();
		return i1;
	}

	public final static String md5Encoder(byte[] buffer) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(buffer);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public final static String md5Encoder32(byte[] buffer) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(buffer);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String md5Encoder16(byte[] buffer) {
		String result = md5Encoder(buffer);
		System.out.println("MD5 32位：" + result);
		System.out.println("MD5 16位：" + result.substring(8, 24));
		return result.substring(8, 24);
	}

	/**
	 * TODO 二进制转十六进制字符串
	 * 
	 * @param src @return String @throws
	 */
	public static String bytes2HexString(byte[] b) {
		String r = "";

		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			r += hex.toUpperCase();
		}

		return r;
	}
	
	public static int ByteArrayToInt(byte[] bArr) {
		if (bArr.length != 4) {
			return -1;
		}
		return (int) ((((bArr[3] & 0xff) << 24) | ((bArr[2] & 0xff) << 16) | ((bArr[1] & 0xff) << 8) | ((bArr[0] & 0xff) << 0)));
	}

}
