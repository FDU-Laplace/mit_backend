package com.missiongroup.starring.modular.vhis.data.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: IscsDto
 * @Description: iscs数据DTO
 * @author xuwei
 * @date 2020年2月4日 下午3:13:41
 *
 */
public class IscsDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String trainnum;
	
	private String mvbdata;
	
	private Date recordtime;
	
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

	public String getTrainnum() {
		return trainnum;
	}

	public void setTrainnum(String trainnum) {
		this.trainnum = trainnum;
	}
	
	public String getMvbdata() {
		return mvbdata;
	}

	public void setMvbdata(String mvbdata) {
		this.mvbdata = mvbdata;
	}
	

	
	public Date getRecordtime() {
		return recordtime;
	}

	public void setRecordtime(Date recordtime) {
		this.recordtime = recordtime;
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
}
