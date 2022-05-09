package com.missiongroup.starring.core.nettyserver.utils;

import com.missiongroup.starring.core.nettyserver.entity.Constants;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;



public class ImgUtils {
	/**
	 * 删除指定ip开头的图片
	 */
	public static void delFileByIp(String ip) {
		String imgFiles = Constants.platformTempPath;
		File files = new File(imgFiles);
		File[] fileList = files.listFiles();
		for (File file : fileList) {
			if (file.getName().contains(ip)) {
				file.delete();
			}
		}
	}

	/**
	 * 返回图片路径
	 */
	public static String getImgAddress(String ip) {
		String imgFiles = Constants.platformTempPath;
		File files = new File(imgFiles);
		File[] fileList = files.listFiles();
		for (File file : fileList) {
			if (file.getName().contains(ip)) {
				return imgFiles + "//" + file.getName();
			}
		}
		return null;
	}

	/**
	 * 创建图片
	 */
	public static boolean createImg(byte[] b, String name) {
		File writename = new File(name);
		try {
			FileOutputStream fos = new FileOutputStream(writename);
			fos.write(b, 0, b.length);
			fos.flush();
			fos.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}