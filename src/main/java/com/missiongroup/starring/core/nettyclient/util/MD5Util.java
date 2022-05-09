package com.missiongroup.starring.core.nettyclient.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class MD5Util {

	private static char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	private static MessageDigest messagedigest = null;
	private static final int CACHE_SIZE = 2048;

	static {
		try {
			messagedigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException ex) {
		}
	}

	public static String createFileMD5(File file) throws IOException {
		InputStream in = new FileInputStream(file);
		byte[] cache = new byte[CACHE_SIZE];
		int nRead = 0;
		while ((nRead = in.read(cache)) != -1) {
			messagedigest.update(cache, 0, nRead);
		}
		in.close();
		return bufferToHex(messagedigest.digest());
	}

	public static String createMD5(String s) {
		return createMD5(s.getBytes());
	}

	public static String createMD5(byte[] bytes) {
		messagedigest.update(bytes);
		return bufferToHex(messagedigest.digest());
	}

	private static String bufferToHex(byte bytes[]) {
		return bufferToHex(bytes, 0, bytes.length);
	}

	private static String bufferToHex(byte bytes[], int m, int n) {
		StringBuffer stringbuffer = new StringBuffer(2 * n);
		int k = m + n;
		for (int l = m; l < k; l++) {
			appendHexPair(bytes[l], stringbuffer);
		}
		return stringbuffer.toString();
	}

	private static void appendHexPair(byte bt, StringBuffer stringbuffer) {
		char c0 = hexDigits[(bt & 0xf0) >> 4];
		char c1 = hexDigits[bt & 0xf];
		stringbuffer.append(c0);
		stringbuffer.append(c1);
	}

	public static boolean checkPassword(String password, String passwordMD5String) {
		String s = createMD5(password);
		return s.equals(passwordMD5String);
	}

	public static byte[] getMD5Bytes(byte[] bytes) {
		messagedigest.update(bytes);
		return messagedigest.digest();
	}

	public static boolean checkMD5Bytes(byte[] target, byte[] md5) {
		messagedigest.update(target);
		return MessageDigest.isEqual(messagedigest.digest(), md5);
	}
	
	public static byte[] getMD516Byte(String md5Str) {
		LinkedList<byte[]> contents = new LinkedList<byte[]>();
		while (!md5Str.equals("")) {
			String tmp = md5Str.substring(0, 2);
			Integer x = Integer.parseInt(tmp, 16);
			contents.add(Utils.intToByte(x, 1));
			md5Str = md5Str.substring(2);
		}
		Utils.byteMerger(contents);
		return contents.get(0);
	}

}
