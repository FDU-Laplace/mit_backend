package com.missiongroup.starring.common.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 * 
 * @ClassName: PageResult
 * @Description: 返回給前台的分页实体
 * @author TAIHUAYUN
 * @date 2018年4月18日 下午4:09:50
 *
 */
public class PageResult implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<?> rows;

	private Integer size;

	private Long totalSize;

	private Integer totalPage;

	public PageResult() {
	}

	public PageResult(Page<?> pageData) {
		this.rows = pageData.getContent();
		this.size = pageData.getSize();
		this.totalSize = pageData.getTotalElements();
		this.totalPage = pageData.getTotalPages();
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
}
