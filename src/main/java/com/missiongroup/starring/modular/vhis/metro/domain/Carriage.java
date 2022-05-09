package com.missiongroup.starring.modular.vhis.metro.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "vhis_carriage")
public class Carriage implements Serializable {
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
	 * 关联线路ID
	 */
	private String relationLine;
	
    /**
	 * 关联列车ID
	 */
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "train_uuid")
	@JsonIgnore
	private Train relationTrain;
	
    /**
	 * 车厢ID
	 */
	private String carriageId;
	
    /**
	 * 车厢类型
	 */
	private Integer carriageType;
	
    /**
	 * 车厢名称
	 */
	private String carriageName;
	
    /**
	 * 车厢code
	 */
	private String carriageCode;
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
	 * 创建用户ID
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

	public String getRelationLine() {
		return relationLine;
	}

	public void setRelationLine(String relationLine) {
		this.relationLine = relationLine;
	}
	
	public Train getRelationTrain() {
		return relationTrain;
	}

	public void setRelationTrain(Train relationTrain) {
		this.relationTrain = relationTrain;
	}
	
	public String getCarriageId() {
		return carriageId;
	}

	public void setCarriageId(String carriageId) {
		this.carriageId = carriageId;
	}
	
	public Integer getCarriageType() {
		return carriageType;
	}

	public void setCarriageType(Integer carriageType) {
		this.carriageType = carriageType;
	}
	
	public String getCarriageName() {
		return carriageName;
	}

	public void setCarriageName(String carriageName) {
		this.carriageName = carriageName;
	}
	
	public String getCarriageCode() {
		return carriageCode;
	}

	public void setCarriageCode(String carriageCode) {
		this.carriageCode = carriageCode;
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
}
