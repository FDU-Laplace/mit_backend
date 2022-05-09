package com.missiongroup.starring.core.ftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.apache.log4j.Logger;

import com.missiongroup.starring.core.util.ToolUtil;

@SuppressWarnings("all")
public class FTPUtils {

	private FTPClient ftpClient = new FTPClient();

	private OutputStream os;

	private static final Logger LOGGER = Logger.getLogger(FTPUtils.class);

	public String uploadFile(String pathName, String fileName, InputStream is, Map<String, String> ftp, boolean isRand) {
		String filePath = "";
		String ftpFileName = "";
		try {
			connect(ftp);
			createDirectory(pathName, ftpClient);
			if (isRand) {
				if (fileName.lastIndexOf(".") != -1) {
					ftpFileName = UUID.randomUUID().toString() + fileName.substring(fileName.lastIndexOf("."));
				} else {
					ftpFileName = UUID.randomUUID().toString();
				}
			} else {
				ftpFileName = fileName;
			}
			ftpClient.storeFile(ftpFileName, is);
			close();
			filePath = pathName + "/" + ftpFileName;
			LOGGER.info(fileName + "上传成功!");
		} catch (Exception e) {
			LOGGER.error(fileName + "上传失败!", e);
			close();
		}
		return filePath;
	}

	public OutputStream downloadFile(String path, String fileName, HttpServletResponse response, Map<String, String> ftp) {
		try {
			connect(ftp);
			if (!isDir(fileName)) {
				ftpClient.changeWorkingDirectory(path);
				FTPFile[] fs = ftpClient.listFiles();
				for (FTPFile ff : fs) {
					if (ff.getName().equals(fileName)) {
						os = response.getOutputStream();
						ftpClient.retrieveFile(fileName, os);
					}
				}
			}
			close();
			LOGGER.info(fileName + "下载成功！");
		} catch (Exception e) {
			LOGGER.error(fileName + "下载失败！", e);
		}
		return os;
	}

	public OutputStream downloadFiles(String path, List<Map<String, String>> fileNames, File temDir, Map<String, String> ftp) {
		try {
			connect(ftp);
			ftpClient.changeWorkingDirectory(path);
			FTPFile[] fs = ftpClient.listFiles();
			for (Map<String, String> fileName : fileNames) {
				String ftpFileName = fileName.get("fileName");
				String fileRealName = fileName.get("realName");
				if (ToolUtil.isNotEmpty(ftpFileName)) {
					for (FTPFile ff : fs) {
						if (ff.getName().equals(ftpFileName)) {
							InputStream is = ftpClient.retrieveFileStream(ftpFileName);
							if (is != null) {
								OutputStream writer = new FileOutputStream(temDir.getPath() + "/" + fileRealName);
								int len;
								byte[] buf = new byte[0xffff];
								while ((len = is.read(buf)) != -1) {
									writer.write(buf, 0, len);
								}
								writer.close();
								is.close();
							}
							ftpClient.completePendingCommand();
							break;
						}
					}
				}
				LOGGER.info(fileRealName + "下载成功！");
			}
			close();
		} catch (Exception e) {
			LOGGER.error("下载失败！", e);
		}
		return os;
	}

	/**
	 * 建立链接
	 */
	private void connect(Map<String, String> ftp) {
		try {
			ftpClient = new FTPClient();
			LOGGER.info("开始链接...");
			ftpClient.connect(ftp.get("url"));
			int reply = ftpClient.getReplyCode(); // ftp响应码
			if (!FTPReply.isPositiveCompletion(reply)) { // ftp拒绝链接
				LOGGER.error("ftp拒绝链接...");
				ftpClient.disconnect();
			}
			ftpClient.login(ftp.get("loginName"), ftp.get("password"));
			ftpClient.enterLocalPassiveMode(); // 设置被动模式 通知server端开通端口传输数据
			ftpClient.setBufferSize(256);
			ftpClient.setDataTimeout(60000); // 设置传输超时时间为60秒
			ftpClient.setConnectTimeout(60000); // 连接超时为60秒
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			ftpClient.setControlEncoding("utf-8");
			LOGGER.info("登录成功！");
		} catch (SocketException e) {
			LOGGER.error("登录失败！", e);
		} catch (IOException e) {
			LOGGER.error("登录失败！", e);
		}
	}

	/**
	 * 退出FTP登录关闭链接 并 关闭输入输出流
	 * 
	 * @param os
	 */
	private void close() {
		try {
			ftpClient.logout();
			LOGGER.info("退出登录！");
		} catch (IOException e) {
			LOGGER.error("退出登录失败！", e);
		}
	}

	/**
	 * 删除ftp上的文件
	 * 
	 * @param srcFname
	 * @return true || false
	 */
	public boolean removeFile(Map<String, String> ftpConfig, String srcFname) {
		boolean flag = false;
		try {
			connect(ftpConfig);
			flag = ftpClient.deleteFile(srcFname);
			LOGGER.info("删除" + srcFname +"文件成功！");
			close();
		} catch (IOException e) {
			close();
			LOGGER.error("删除" + srcFname +"文件失败！", e);
		}
		return flag;
	}

	/**
	 * 判断是否是目录
	 * 
	 * @param fileName
	 * @return
	 */
	public boolean isDir(String fileName) {
		try {
			boolean flag = ftpClient.changeWorkingDirectory(fileName);
			LOGGER.info("判断是否是目录" + flag);
			return flag;
		} catch (IOException e) {
			LOGGER.error("判断是否是目录失败！", e);
		}
		return false;
	}

	public void createDirectory(String remote, FTPClient ftpClient) throws IOException {
		String[] temp = remote.split("/");
		for (String path : temp) {
			// 没有路径就先创建路径再到路径下
			makeDirectory(path, ftpClient);
			ftpClient.changeWorkingDirectory(path);
		}
	}

	/**
	 * @param path
	 * @param ftpClient
	 */
	public void makeDirectory(String path, FTPClient ftpClient) {
		boolean notExist = true;
		try {
			FTPFile[] ftpFileArr = ftpClient.listFiles();
			// 遍历下看看路径是否已经存在了
			for (FTPFile tmp : ftpFileArr) {
				if (tmp.getName().equals(path)) {
					notExist = false;
					break;
				}
			}
			if (notExist) {
				notExist = ftpClient.makeDirectory(path);
				LOGGER.info("创建" + path +"目录成功！");
			}
		} catch (IOException e) {
			e.printStackTrace();
			LOGGER.info("创建" + path + "文件目录失败！");
		}
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	public OutputStream getOs() {
		return os;
	}

	public void setOs(OutputStream os) {
		this.os = os;
	}

	public static void main(String[] args) {
		Map<String, String> ftp = new HashMap<String, String>();
		ftp.put("url", "192.168.0.128");
		ftp.put("loginName", "mission_ftp");
		ftp.put("password", "111111");
		boolean flag = new FTPUtils().removeFile(ftp, "resource/e0b1bd60-d950-435f-b06a-6f6dfbe855a2.doc");
		System.out.println("flag:" + flag);

	}
}
