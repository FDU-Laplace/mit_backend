package com.missiongroup.starring.modular.vhis.metro.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "vhis_line")
public class Line implements Serializable {
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
	 * 线路ID
	 */
	private String lineId;
	
    /**
	 * 线路类型  0-主线 1-环线 2-支线 3-延长线
	 */
	private Integer lineType;
	
    /**
	 * 线路颜色
	 */
	private String lineColor;
	
    /**
	 * 线路名称
	 */
	private String lineName;
	
    /**
	 * 英文名称
	 */
	private String lineNameEn;
	
    /**
	 * 线路编号
	 */
	private String lineNum;
	
    /**
	 * 线路简码
	 */
	private String lineCode;
	
    /**
	 * 是否开通
	 */
	private Boolean isRun;

	/**
	 * 列车列表
	 */
	@ManyToMany(targetEntity = Train.class,fetch = FetchType.EAGER)
	@JoinTable(name = "line_and_train",
			joinColumns = @JoinColumn(name = "line_uuid", referencedColumnName = "uuid", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "train_uuid", referencedColumnName = "uuid", nullable = false))
	@JsonIgnore
	private List<Train> trains;
	/**
	 * 运营公司
	 */
	private String company;
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
