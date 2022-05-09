package com.missiongroup.starring.common.exception;

import com.missiongroup.starring.core.exception.StarringException;

/**
 * 资源上传错误异常
 *
 * @author mission
 * @date 2017-05-05 23:52
 */
public class ResourceUploadErrorException extends StarringException {
	private static final long serialVersionUID = 1L;
	
	public ResourceUploadErrorException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
