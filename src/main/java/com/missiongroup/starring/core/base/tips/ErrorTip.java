package com.missiongroup.starring.core.base.tips;

/**
 * 返回给前台的错误提示
 *
 * @author mission
 * @date 2016年11月12日 下午5:05:22
 */
public class ErrorTip extends Tip {

	private Boolean kaptcha;

    public ErrorTip(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }
    
	public Boolean getKaptcha() {
		return kaptcha;
	}
	public void setKaptcha(Boolean kaptcha) {
		this.kaptcha = kaptcha;
	}
    
}
