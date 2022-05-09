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
 * @ClassName: OperationLog
 * @Description: 操作日志信息表
 * @author TAIHUAYUN
 * @date 2018年4月16日 下午3:19:59
 *
 */
@Entity
@Table(name = "sys_operation_log")
public class OperationLog implements Serializable {
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
	 * 日志名称
	 */
	private String name;

	/**
	 * 用户id
	 */
	private String userId;

	/**
	 * 类名称
	 */
	private String className;

	/**
	 * 方法名称
	 */
	private String method;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 是否成功
	 */
	private String succeed;

	/**
	 * 备注
	 */
	@Lob
	private String message;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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
}
