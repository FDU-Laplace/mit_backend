package com.missiongroup.starring.modular.system.domain.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @ClassName: RoleDto
 * @Description: 角色DTO
 * @author TAIHUAYUN
 * @date 2018年4月19日 上午9:45:28
 *
 */
public class RoleDto implements Serializable, Comparable<RoleDto> {
	private static final long serialVersionUID = 1L;

	private String id;

	private Integer sort;

	private String name;

	private String departId;

	private String departName;

	private String remark;

	private Date createTime;

	private Date updateTime;

	private String createUserId;

	private String updateUserId;

	private String parentIds;

	private String[] parentIdList;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartId() {
		return departId;
	}

	public void setDepartId(String departId) {
		this.departId = departId;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
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

	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}

	public String[] getParentIdList() {
		return parentIdList;
	}

	public void setParentIdList(String[] parentIdList) {
		this.parentIdList = parentIdList;
	}

	@Override
	public int compareTo(RoleDto o) {
		RoleDto role = (RoleDto) o;
		Integer sort = role.getSort();
		if (sort == null) {
			sort = 0;
		}
		if (this.sort == null) {
			this.sort = 0;
		}
		return this.sort.compareTo(sort);
	}
}
