package com.zuimeihui.demo.common.dto;

import java.io.Serializable;

import com.zuimeihui.demo.common.constants.Constants;

/**
 * 分页
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 10:15:06
 */
public class PageCustom implements Serializable {

	private static final long serialVersionUID = 1L;

	private String fields = "id";

	private String order = "desc";

	private Boolean isPage = false;

	private Integer page = 1;

	private Integer pageSize = Constants.PAGE_SIZE;

	public String getFields() {
		return fields;
	}

	public void setFields(String fields) {
		this.fields = fields;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Boolean getIsPage() {
		return isPage;
	}

	public void setIsPage(Boolean isPage) {
		this.isPage = isPage;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = (page == null || page <= 0) ? 1 : page;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = (pageSize == null || pageSize <= 0) ? Constants.PAGE_SIZE : pageSize;
	}

	public Integer getStart() {
		return (page - 1) * pageSize;
	}

	public Integer getEnd() {
		return pageSize;
	}
}
