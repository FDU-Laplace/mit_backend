package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.Map;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

/**
 * 
 * @ClassName: PageParam
 * @Description: 分页查询实体
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午1:59:41
 *
 */
//@ApiModel(value="分页参数",description="分页参数")
public class PageParam implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "当前页码",required = true)
	private Integer page;
	@ApiModelProperty(value = "每页条数",required = true)
	private Integer size;
	@ApiModelProperty(value = "排序参数",required = true)
	private String properties;
	@ApiModelProperty(value = "排序",required = true,example = "正序：asc；倒序：desc")
	private String direction;
	@ApiModelProperty(value = "查询参数",example = "{}")
	private Map<String, Object> condition;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public String getProperties() {
		return properties;
	}

	public void setProperties(String properties) {
		this.properties = properties;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Map<String, Object> getCondition() {
		return condition;
	}

	public void setCondition(Map<String, Object> condition) {
		this.condition = condition;
	}

	private Direction formatDirection() {
		return PageDirection.ASC.equalsIgnoreCase(this.direction) ? Direction.ASC : Direction.DESC;
	}

	private Sort formatSort() {
		return new Sort(this.formatDirection(), this.properties);
	}

	public Pageable formatPageable() {
		return new PageRequest(this.page - 1, this.size, this.formatSort());
	}
}
