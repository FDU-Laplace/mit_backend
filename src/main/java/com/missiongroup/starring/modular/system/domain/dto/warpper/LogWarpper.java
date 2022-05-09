package com.missiongroup.starring.modular.system.domain.dto.warpper;

import java.util.Map;

import com.missiongroup.starring.common.constant.factory.ConstantFactory;
import com.missiongroup.starring.core.base.warpper.BaseWarpper;
import com.missiongroup.starring.modular.system.domain.LoginLog;
import com.missiongroup.starring.modular.system.domain.OperationLog;
import com.missiongroup.starring.modular.system.domain.dto.LoginLogDto;
import com.missiongroup.starring.modular.system.domain.dto.OperationLogDto;

/**
 * 
 * @ClassName: LogWarpper
 * @Description: 日志列表的包装类
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:21:21
 *
 */
public class LogWarpper extends BaseWarpper {
	public LogWarpper(Object list) {
		super(list);
	}

	@Override
	public void warpTheMap(Map<String, Object> map) {

	}

	@Override
	protected Object warpTheEntity(Object entity) {
		if (entity instanceof LoginLog) {
			LoginLogDto loginLogDto = new LoginLogDto();
			LoginLog loginLog = (LoginLog) entity;
			loginLogDto.setId(loginLog.getUuid());
			loginLogDto.setCreateTime(loginLog.getCreateTime());
			loginLogDto.setIp(loginLog.getIp());
			loginLogDto.setSucceed(loginLog.getSucceed());
			loginLogDto.setMessage(loginLog.getMessage());
			loginLogDto.setType(loginLog.getType());
			loginLogDto.setUserId(loginLog.getUserId());
			loginLogDto.setTypeName(ConstantFactory.me().getLogTypeName(loginLog.getType()));
			loginLogDto.setUserName(ConstantFactory.me().getUserNameById(loginLog.getUserId()));
			return loginLogDto;
		}
		if (entity instanceof OperationLog) {
			OperationLogDto operationLogDto = new OperationLogDto();
			OperationLog operationLog = (OperationLog) entity;
			operationLogDto.setId(operationLog.getUuid());
			operationLogDto.setName(operationLog.getName());
			operationLogDto.setCreateTime(operationLog.getCreateTime());
			operationLogDto.setClassName(operationLog.getClassName());
			operationLogDto.setMethod(operationLog.getMethod());
			operationLogDto.setSucceed(operationLog.getSucceed());
			operationLogDto.setMessage(operationLog.getMessage());
			operationLogDto.setType(operationLog.getType());
			operationLogDto.setUserId(operationLog.getUserId());
			operationLogDto.setTypeName(ConstantFactory.me().getLogTypeName(operationLog.getType()));
			operationLogDto.setUserName(ConstantFactory.me().getUserNameById(operationLog.getUserId()));
			return operationLogDto;
		}
		return null;
	}
}
