package com.missiongroup.starring.modular.vhis.config.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: CBConfigDto
 * @Description: 断路器DTO
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:41:20
 *
 */
public class CBConfigDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;
	
	private String car;
	
	private String description;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
