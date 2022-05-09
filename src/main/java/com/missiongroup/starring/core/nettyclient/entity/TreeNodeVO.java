package com.missiongroup.starring.core.nettyclient.entity;

import java.util.List;

public class TreeNodeVO {

	private String ip;
	private List<TreeNodeVO> childNode;
	private String id;
	private String parentId;
	private String port;
	private String type;

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public List<TreeNodeVO> getChildNode() {
		return this.childNode;
	}

	public void setChildNode(List<TreeNodeVO> childNode) {
		this.childNode = childNode;
	}

	public String getPort() {
		return this.port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getId() {
		return id;
	}

	public String getParentId() {
		return parentId;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public void setType(String type) {
		this.type = type;
	}

}
