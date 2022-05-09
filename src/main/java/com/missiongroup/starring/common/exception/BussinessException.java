package com.missiongroup.starring.common.exception;

import com.missiongroup.starring.core.exception.StarringException;

/**
 * @author mission
 * @Description 业务异常的封装
 * @date 2016年11月12日 下午5:05:10
 */
public class BussinessException extends StarringException {
	private static final long serialVersionUID = 1L;

	public BussinessException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
