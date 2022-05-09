package com.missiongroup.starring.core.shiro;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 自定义Authentication对象，使得Subject除了携带用户的登录名外还可以携带更多信息
 *
 * @author mission
 * @date 2016年12月5日 上午10:26:43
 */
public class ShiroUser implements Serializable {
	private static final long serialVersionUID = 1L;

	public String id; // 主键ID
	public String account; // 账号
	public String name; // 姓名
	//public String departId; // 部门id
	public String departName; // 部门名称
	public String position; // 职位
	public List<Map<String, Object>> departs; // 部门列表
	public List<String> roleList; // 角色集
	public List<String> roleCode; // 角色编号集
	public List<String> roleNames; // 角色名称集
	public List<Map<String, Object>> areas; // 区域列表
	public String ip;
	public String mac;
	public String userEngineer; //用户所属区域总工
	public String userOfficer; //用户所属区域负责人

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getDepartId() {
//		return departId;
//	}

//	public void setDepartId(String departId) {
//		this.departId = departId;
//	}

	public List<String> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<String> roleList) {
		this.roleList = roleList;
	}

	public String getDepartName() {
		return departName;
	}

	public void setDepartName(String departName) {
		this.departName = departName;
	}

	public List<String> getRoleNames() {
		return roleNames;
	}

	public void setRoleNames(List<String> roleNames) {
		this.roleNames = roleNames;
	}

	public List<Map<String, Object>> getAreas() {
		return areas;
	}

	public void setAreas(List<Map<String, Object>> areas) {
		this.areas = areas;
	}

	public List<Map<String, Object>> getDeparts() {
		return departs;
	}

	public void setDeparts(List<Map<String, Object>> departs) {
		this.departs = departs;
	}

	public List<String> getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(List<String> roleCode) {
		this.roleCode = roleCode;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getIp() {
		return ip;
	}

	public String getMac() {
		return mac;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getUserEngineer() {
		return userEngineer;
	}

	public void setUserEngineer(String userEngineer) {
		this.userEngineer = userEngineer;
	}

	public String getUserOfficer() {
		return userOfficer;
	}

	public void setUserOfficer(String userOfficer) {
		this.userOfficer = userOfficer;
	}
}