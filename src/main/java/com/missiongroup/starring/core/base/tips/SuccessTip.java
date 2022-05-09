package com.missiongroup.starring.core.base.tips;

/**
 * 返回给前台的成功提示
 *
 * @author mission
 * @date 2016年11月12日 下午5:05:22
 */
public class SuccessTip extends Tip {
	
	public String filed;
	
	public SuccessTip(){
		super.filedCode = filed;
		super.code = 200;
		super.message = "操作成功";
	}

	public String getFiled() {
		return filed;
	}

	public void setFiled(String filed) {
		this.filed = filed;
	}
	
	
	
}
