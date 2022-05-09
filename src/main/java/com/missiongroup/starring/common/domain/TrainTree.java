package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 
 * @ClassName: TrainTree
 * @Description: 列车树
 * @author YAOWEI
 * @date 2018年9月19日 上午10:09:55
 *
 */
public class TrainTree implements Serializable {
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
	 * 编号
	 */
	private String code;
	
	/**
	 * 节点存储data
	 */
	private Map<String, Object> data;
	
	/**
	 * 子节点树
	 */
	private List<TrainTree> children;
	
	/**
	 * 线路id
	 */
	private String lineId;
	
	/**
	 * 车库id
	 */
	private String garageId;
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
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public List<TrainTree> getChildren() {
		return children;
	}

	public void setChildren(List<TrainTree> children) {
		this.children = children;
	}

	public String getLineId() {
		return lineId;
	}

	public void setLineId(String lineId) {
		this.lineId = lineId;
	}

	public String getGarageId() {
		return garageId;
	}

	public void setGarageId(String garageId) {
		this.garageId = garageId;
	}
}