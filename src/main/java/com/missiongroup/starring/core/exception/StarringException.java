package com.missiongroup.starring.core.exception;

/**
 * 
 * @ClassName: StarringException
 * @Description: 业务异常的封装
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午11:12:56
 *
 */
public class StarringException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// 友好提示的code码
	protected String friendlyCode;

	// 友好提示
	protected String friendlyMsg;

	// 业务异常跳转的页面
	protected String urlPath;

	protected StarringException(String friendlyCode, String friendlyMsg, String urlPath) {
		this.setValues(friendlyCode, friendlyMsg, urlPath);
	}

	public StarringException(StarringExceptionEnum bizExceptionEnum) {
		this.setValues(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}

	private void setValues(String friendlyCode, String friendlyMsg, String urlPath) {
		this.friendlyCode = friendlyCode;
		this.friendlyMsg = friendlyMsg;
		this.urlPath = urlPath;
	}

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
