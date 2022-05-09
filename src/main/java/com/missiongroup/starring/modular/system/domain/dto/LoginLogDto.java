package com.missiongroup.starring.modular.system.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: LoginLogDto
 * @Description: 登录日志DTO
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:41:20
 *
 */
public class LoginLogDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;

	private Integer type;

	private String userId;

	private Date createTime;

	private String succeed;

	private String message;

	private String ip;

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

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
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
}
