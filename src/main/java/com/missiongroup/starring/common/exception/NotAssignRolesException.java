package com.missiongroup.starring.common.exception;

import com.missiongroup.starring.core.exception.StarringException;

/**
 * 用户未分配角色异常
 *
 * @author mission
 * @date 2017-05-05 23:52
 */
public class NotAssignRolesException extends StarringException {
	private static final long serialVersionUID = 1L;
	
	public NotAssignRolesException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
