package com.missiongroup.starring.modular.vhis.data.domain;

public class TrainDataEntiy extends TrainData{
	/**
	 *是否有故障 0没故障 1有故障
	 */
	private String trian_isFault;
	
	/**
	 *是否有报警 0没报警 1有报警
	 */
	private String trian_isAlert;

	public String getTrian_isFault() {
		return trian_isFault;
	}

	public void setTrian_isFault(String trian_isFault) {
		this.trian_isFault = trian_isFault;
	}

	public String getTrian_isAlert() {
		return trian_isAlert;
	}

	public void setTrian_isAlert(String trian_isAlert) {
		this.trian_isAlert = trian_isAlert;
	}
	
	
	
}
