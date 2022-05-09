package com.missiongroup.starring.core.log.factory;

import java.util.Date;

import com.missiongroup.starring.common.constant.state.LogSucceed;
import com.missiongroup.starring.common.constant.state.LogType;
import com.missiongroup.starring.modular.system.domain.LoginLog;
import com.missiongroup.starring.modular.system.domain.OperationLog;

/**
 * 日志对象创建工厂
 *
 * @author mission
 * @date 2016年12月6日 下午9:18:27
 */
public class LogFactory {

    /**
     * 创建操作日志
     *
     * @author mission
     * @Date 2017/3/30 18:45
     */
    public static OperationLog createOperationLog(LogType logType, String userId, String bussinessName, String clazzName, String methodName, String msg, LogSucceed succeed) {
        OperationLog operationLog = new OperationLog();
        operationLog.setType(logType.getType());
        operationLog.setName(bussinessName);
        operationLog.setUserId(userId);
        operationLog.setClassName(clazzName);
        operationLog.setMethod(methodName);
        operationLog.setCreateTime(new Date());
        operationLog.setSucceed(succeed.getMessage());
        operationLog.setMessage(msg);
        return operationLog;
    }

    /**
     * 创建登录日志
     *
     * @author mission
     * @Date 2017/3/30 18:46
     */
    public static LoginLog createLoginLog(LogType logType, String userId,String loginStatus, String msg,String ip) {
        LoginLog loginLog = new LoginLog();
        loginLog.setType(logType.getType());
        loginLog.setUserId(userId);
        loginLog.setCreateTime(new Date());
        loginLog.setSucceed(loginStatus);
        loginLog.setIp(ip);
        loginLog.setMessage(msg);
        return loginLog;
    }
}
