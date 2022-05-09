package com.missiongroup.starring.common.exception;

import com.missiongroup.starring.core.exception.StarringException;

/**
 * netty连接错误异常
 *
 * @author YAOWEI
 * @date 2018-07-02 16:52
 */
public class NettyConnectErrorException extends StarringException {
	private static final long serialVersionUID = 1L;
	
	public NettyConnectErrorException(BizExceptionEnum bizExceptionEnum) {
		super(bizExceptionEnum.getCode(), bizExceptionEnum.getMessage(), bizExceptionEnum.getUrlPath());
	}
}
