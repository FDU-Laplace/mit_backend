package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.Map;

/**
 * 
 * @ClassName: ProcessParam
 * @Description: 流程发起参数实体
 * @author TAIHUAYUN
 * @date 2018年5月8日 上午11:16:23
 *
 */
public class ProcessParam implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 关联实体uuid
	 */
	private String uuid;

	/**
	 * 关联参数map
	 */
	private Map<String, Object> condition;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}
}
