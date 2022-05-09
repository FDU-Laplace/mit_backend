package com.missiongroup.starring.modular.system.domain.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: DepartDto
 * @Description: 部门DTO
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午10:49:02
 *
 */
public class DepartDto implements Serializable, Comparable<DepartDto> {
	private static final long serialVersionUID = 1L;

	private String id;

	private Integer sort;

	private String parentId;

	private String parentIds;

	private String name;

	private Date createTime;

	private Date updateTime;

	private String createUserId;

	private String updateUserId;

	private String[] parentIdList;

	private List<DepartDto> children;

	private String label;

	private String value;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String[] getParentIdList() {
		return parentIdList;
	}

	public void setParentIdList(String[] parentIdList) {
		this.parentIdList = parentIdList;
	}

	public List<DepartDto> getChildren() {
		return children;
	}

	public void setChildren(List<DepartDto> children) {
		this.children = children;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public int compareTo(DepartDto o) {
		DepartDto depart = (DepartDto) o;
		Integer sort = depart.getSort();
		if (sort == null) {
			sort = 0;
		}
		if (this.sort == null) {
			this.sort = 0;
		}
		return this.sort.compareTo(sort);
	}
}
