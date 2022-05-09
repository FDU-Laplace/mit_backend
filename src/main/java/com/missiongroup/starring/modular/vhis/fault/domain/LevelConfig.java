package com.missiongroup.starring.modular.vhis.fault.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "vhis_level_config")
public class LevelConfig implements Serializable {
	private static final long serialVersionUID = 1L;

    /**
	 * 唯一标识UUID
	 */
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '主键,唯一标识UUID'")
	private String uuid;

    /**
	 * 等级名称
	 */
	private String levelName;
	
    /**
	 * 等级编码
	 */
	private String faultLevel;

    /**
	 * 是否闪烁
	 */
	private String twinkle;
	
    /**
	 * 是否有声音
	 */
	private String voice;
	
    /**
	 * 字体颜色
	 */
	private String color;

	/**
	 * 是否轻微故障
	 */
	private String minor;

	/**
	 * 图标
	 */
	private String icon;

	/**
	 * 背景颜色
	 */
	private String backgroundColor;

	/**
	 * 创建时间
	 */
	@Column(columnDefinition="datetime COMMENT '创建时间'")
	private Date createTime;
	
	/**
	 * 修改时间
	 */
	@Column(columnDefinition="datetime COMMENT '修改时间'")
	private Date updateTime;

	/**
	 * 创建用户ID/FaultCtl/list
	 */
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '创建用户ID'")
	private String createUserId;

	/**
	 * 修改用户ID
	 */
	@Column(length = 32, columnDefinition="varchar(32) COMMENT '修改用户ID'")
	private String updateUserId;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLevelName() {
		return levelName;
	}

	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	public String getFaultLevel() {
		return faultLevel;
	}

	public void setFaultLevel(String faultLevel) {
		this.faultLevel = faultLevel;
	}

	public String getTwinkle() {
		return twinkle;
	}

	public void setTwinkle(String twinkle) {
		this.twinkle = twinkle;
	}

	public String getVoice() {
		return voice;
	}

	public void setVoice(String voice) {
		this.voice = voice;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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

	public String getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(String createUserId) {
		this.createUserId = createUserId;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public LevelConfig() {
	}

	public LevelConfig(String uuid) {
		this.uuid = uuid;
	}
}
