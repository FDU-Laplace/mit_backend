package com.missiongroup.starring.modular.system.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: OperationLogDto
 * @Description: 系统业务日志DTO
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:41:20
 *
 */
public class OperationLogDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	
	private String name;

	private Integer type;

	private String userId;

	private Date createTime;

	private String succeed;

	private String className;

	private String method;

	private String message;

	private String typeName;

	private String userName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSucceed() {
		return succeed;
	}

	public void setSucceed(String succeed) {
		this.succeed = succeed;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
