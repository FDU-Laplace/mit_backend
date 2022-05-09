package com.missiongroup.starring.common.constant.state;

/**
 * 日志类型
 *
 * @author mission
 * @Date 2017年1月22日 下午12:14:59
 */
public enum LogType {
	// 0:登录成功日志  1:登录失败日志  2:退出日志 3:异常日志  4:业务日志
    LOGIN(0,"登录成功日志"),
    LOGIN_FAIL(1,"登录失败日志"),
    EXIT(2,"退出日志"),
    EXCEPTION(3,"异常日志"),
    BUSSINESS(4,"业务日志");

    Integer type;
    String message;

    LogType(Integer type,String message) {
        this.type = type;
        this.message = message;
    }

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
}
