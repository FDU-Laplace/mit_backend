package com.missiongroup.starring.common.constant.state;

/**
 * 
 * @ClassName: Order
 * @Description: 数据库排序
 * @author TAIHUAYUN
 * @date 2018年4月13日 下午1:30:04
 *
 */
public enum Order {
	ASC("asc"), DESC("desc");

	private String des;

	Order(String des) {
		this.des = des;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
}
