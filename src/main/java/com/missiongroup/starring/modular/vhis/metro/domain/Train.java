package com.missiongroup.starring.modular.vhis.metro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "vhis_train")
public class Train implements Serializable {
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
	 * 所属线路
	 */
	@ManyToMany(targetEntity = Line.class,mappedBy = "trains")
	private List<Line> lines;
    /**
	 * 列车ID
	 */
	private String trainId;
	
    /**
	 * 列车类型
	 */
	private Integer trainType;
	
    /**
	 * 列车名称
	 */
	private String trainName;
	
    /**
	 * 列车编码
	 */
	private String trainCode;
	/**
	 * 相应的车厢
	 */
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "train_uuid")
	private List<Carriage> carriages;
    /**
	 * 列车备注
	 */
	private String remark;
	
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
	
	public String getTrainId() {
		return trainId;
	}

	public void setTrainId(String trainId) {
		this.trainId = trainId;
	}
	
	public Integer getTrainType() {
		return trainType;
	}

	public void setTrainType(Integer trainType) {
		this.trainType = trainType;
	}
	
	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	
	public String getTrainCode() {
		return trainCode;
	}

	public void setTrainCode(String trainCode) {
		this.trainCode = trainCode;
	}
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public List<Carriage> getCarriages() {
		return carriages;
	}

	public void setCarriages(List<Carriage> carriages) {
		this.carriages = carriages;
	}

	public List<Line> getLines() {
		return lines;
	}

	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
}
