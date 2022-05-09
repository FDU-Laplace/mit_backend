package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: MetroTree
 * @Description: 线路树
 * @author TAIHUAYUN
 * @date 2018年5月14日 上午10:09:55
 *
 */
public class MetroTree implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 节点id
	 */
	private String id;
	
	/**
	 * 节点显示标签
	 */
	private String label;
	
	/**
	 * 节点业务类型
	 */
	private String type;
	
	/**
	 * 节点存储data
	 */
	private Map<String, Object> data;
	
	/**
	 * 子节点树
	 */
	private List<MetroTree> children;
	
	/**
	 * 线路id
	 */
	private String lineId;
	
	/**
	 * 车站id
	 */
	private String statId;
	/**
	 * 唯一标识key
	 */
	private String key;
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<MetroTree> getChildren() {
		return children;
	}

	public void setChildren(List<MetroTree> children) {
		this.children = children;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getStatId() {
		return statId;
	}

	public void setStatId(String statId) {
		this.statId = statId;
	}
}