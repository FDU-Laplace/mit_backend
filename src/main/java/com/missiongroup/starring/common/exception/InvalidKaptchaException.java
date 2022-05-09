package com.missiongroup.starring.common.exception;

import com.missiongroup.starring.core.exception.StarringException;

/**
 * 验证码错误异常
 *
 * @author mission
 * @date 2017-05-05 23:52
 */
public class InvalidKaptchaException extends StarringException {
	private static final long serialVersionUID = 1L;
	
	public InvalidKaptchaException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
