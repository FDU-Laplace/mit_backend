package com.missiongroup.starring.core.log.factory;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.missiongroup.starring.common.constant.state.LogSucceed;
import com.missiongroup.starring.common.constant.state.LogType;
import com.missiongroup.starring.common.exception.BussinessException;
import com.missiongroup.starring.core.log.LogManager;
import com.missiongroup.starring.core.util.SpringContextHolder;
import com.missiongroup.starring.core.util.ToolUtil;
import com.missiongroup.starring.modular.system.domain.LoginLog;
import com.missiongroup.starring.modular.system.domain.OperationLog;
import com.missiongroup.starring.modular.system.service.LoginLogService;
import com.missiongroup.starring.modular.system.service.OperationLogService;

/**
 * 日志操作任务创建工厂
 *
 * @author mission
 * @date 2016年12月6日 下午9:18:27
 */
public class LogTaskFactory {
	private static Logger logger = LoggerFactory.getLogger(LogManager.class);
	
	private static LoginLogService loginLogService = SpringContextHolder.getBean(LoginLogService.class);
	private static OperationLogService operationLogService = SpringContextHolder.getBean(OperationLogService.class);

	public static TimerTask loginLog(final String userId, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				try {
					LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN, userId, LogSucceed.SUCCESS.getMessage(), null, ip);
					loginLogService.save(loginLog);
				} catch (Exception e) {
					logger.error("创建登录日志异常!", e);
				}
			}
		};
	}

	public static TimerTask loginLog(final String username, final String msg, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				LoginLog loginLog = LogFactory.createLoginLog(LogType.LOGIN_FAIL, null, LogSucceed.FAIL.getMessage(), "账号:" + username + "," + msg, ip);
				try {
					loginLogService.save(loginLog);
				} catch (Exception e) {
					logger.error("创建登录失败异常!", e);
				}
			}
		};
	}

	public static TimerTask exitLog(final String userId, final String ip) {
		return new TimerTask() {
			@Override
			public void run() {
				LoginLog loginLog = LogFactory.createLoginLog(LogType.EXIT, userId, null, null, ip);
				try {
					loginLogService.save(loginLog);
				} catch (Exception e) {
					logger.error("创建退出日志异常!", e);
				}
			}
		};
	}

	public static TimerTask bussinessLog(final String userId, final String bussinessName, final String clazzName, final String methodName, final String msg) {
		return new TimerTask() {
			@Override
			public void run() {
				OperationLog operationLog = LogFactory.createOperationLog(LogType.BUSSINESS, userId, bussinessName, clazzName, methodName, msg, LogSucceed.SUCCESS);
				try {
					operationLogService.save(operationLog);
				} catch (Exception e) {
					logger.error("创建业务日志异常!", e);
				}
			}
		};
	}

	public static TimerTask exceptionLog(final String userId, final Exception exception) {
		return new TimerTask() {
			@Override
			public void run() {
				String msg = ToolUtil.getExceptionMsg(exception);
				String message = "";
				if (exception instanceof BussinessException) {
					message = exception.getMessage();
				} else {
					message = "未知错误";
				}
				OperationLog operationLog = LogFactory.createOperationLog(LogType.EXCEPTION, userId, message, exception.getStackTrace()[0].getClassName(), exception.getStackTrace()[0].getMethodName(), msg, LogSucceed.FAIL);
				try {
					operationLogService.save(operationLog);
				} catch (Exception e) {
					logger.error("创建异常日志异常!", e);
				}
			}
		};
	}
}
