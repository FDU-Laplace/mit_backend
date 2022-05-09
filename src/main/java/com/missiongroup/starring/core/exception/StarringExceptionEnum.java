package com.missiongroup.starring.core.exception;

/**
 * 
 * @ClassName: StarringExceptionEnum
 * @Description: 所有业务异常的枚举
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:13:22
 *
 */
public enum StarringExceptionEnum {
	/**
	 * 其他
	 */
	WRITE_ERROR("1160010", "渲染界面错误"),

	/**
	 * 文件上传
	 */
	FILE_READING_ERROR("1020010", "FILE_READING_ERROR!"), FILE_NOT_FOUND("1020020", "FILE_NOT_FOUND!"),

	/**
	 * 错误的请求
	 */
	REQUEST_NULL("1150080", "请求有错误"), SERVER_ERROR("1150070", "服务器异常");

	StarringExceptionEnum(String code, String message) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
	}

	StarringExceptionEnum(String code, String message, String urlPath) {
		this.friendlyCode = code;
		this.friendlyMsg = message;
		this.urlPath = urlPath;
	}

	private String friendlyCode;

	private String friendlyMsg;

	private String urlPath;

	public String getCode() {
		return friendlyCode;
	}

	public void setCode(String code) {
		this.friendlyCode = code;
	}

	public String getMessage() {
		return friendlyMsg;
	}

	public void setMessage(String message) {
		this.friendlyMsg = message;
	}

	public String getUrlPath() {
		return urlPath;
	}

	public void setUrlPath(String urlPath) {
		this.urlPath = urlPath;
	}
}
