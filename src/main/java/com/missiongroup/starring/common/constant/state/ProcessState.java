package com.missiongroup.starring.common.constant.state;

/**
 * 
 * @ClassName: ProcessState
 * @Description: 工作流状态的枚举
 * @author TAIHUAYUN
 * @date 2018年5月8日 上午10:44:25
 *
 */
public enum ProcessState {
	SUBMITING(1, "待提交"), CHECKING(2, "待审核"), PASS(3, "审核通过"), UN_PASS(4, "驳回");

	int code;
	String message;

	ProcessState(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static String valueOf(Integer status) {
		if (status == null) {
			return "";
		} else {
			for (ProcessState s : ProcessState.values()) {
				if (s.getCode() == status) {
					return s.getMessage();
				}
			}
			return "";
		}
	}
}
