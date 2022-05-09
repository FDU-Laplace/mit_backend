package com.missiongroup.starring.modular.system.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * 
 * @ClassName: LoginLog
 * @Description: 登录日志信息表
 * @author TAIHUAYUN
 * @date 2018年4月16日 下午3:17:41
 *
 */
@Entity
@Table(name = "sys_login_log")
public class LoginLog implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "uuid")
	private String uuid;

	/**
	 * 日志类型
	 */
	private Integer type;

	/**
	 * 管理员id
	 */
	private String userId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 是否执行成功
	 */
	private String succeed;

	/**
	 * 具体消息
	 */
	@Lob
	private String message;

	/**
	 * 登录ip
	 */
	private String ip;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
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
}
