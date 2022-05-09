package com.missiongroup.starring.modular.vhis.data.domain;

import java.io.Serializable;
import java.util.List;

public class LineData extends BasicsData implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 线路ID
	 */
	private String lineId;
	/**
	 * 列车数据
	 */
	private List<TrainDataEntiy> TrainDataList;

	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	public List<TrainDataEntiy> getTrainDataList() {
		return TrainDataList;
	}
	public void setTrainDataList(List<TrainDataEntiy> trainDataList) {
		TrainDataList = trainDataList;
	}

	
}
