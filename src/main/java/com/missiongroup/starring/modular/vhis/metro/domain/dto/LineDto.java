package com.missiongroup.starring.modular.vhis.metro.domain.dto;

import com.missiongroup.starring.modular.vhis.metro.domain.Train;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: LineDto
 * @Description: vhis线路DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class LineDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String lineId;
	
	private Integer lineType;
	
	private String lineColor;
	
	private String lineName;
	
	private String lineNameEn;
	
	private String lineNum;
	private List<Train> trains;
	private String lineCode;
	
	private Boolean isRun;
	private String company;
	private Date createTime;
	
	private Date updateTime;
	
	private String createUserName;

	private String updateUserName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	
	public Integer getLineType() {
		return lineType;
	}

	public void setLineType(Integer lineType) {
		this.lineType = lineType;
	}
	
	public String getLineColor() {
		return lineColor;
	}

	public void setLineColor(String lineColor) {
		this.lineColor = lineColor;
	}
	
	public String getLineName() {
		return lineName;
	}

	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	public String getLineNameEn() {
		return lineNameEn;
	}

	public void setLineNameEn(String lineNameEn) {
		this.lineNameEn = lineNameEn;
	}
	
	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}
	
	public String getLineCode() {
		return lineCode;
	}

	public void setLineCode(String lineCode) {
		this.lineCode = lineCode;
	}
	
	public Boolean getIsRun() {
		return isRun;
	}

	public void setIsRun(Boolean isRun) {
		this.isRun = isRun;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCreateUserName() {
		return createUserName;
	}

	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}
}
