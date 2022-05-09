package com.missiongroup.starring.core.base.tips;

/**
 * 返回给前台的提示（最终转化为json形式）
 *
 * @author mission
 * @Date 2017年1月11日 下午11:58:00
 */
public abstract class Tip {
	protected String filedCode;
    protected Integer code;
    protected String message;
    
    public String getFiledCode() {
		return filedCode;
	}

	public void setFiledCode(String filedCode) {
		this.filedCode = filedCode;
	}

	public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
