package com.zuimeihui.demo.common.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 分页
 * 
 * @ClassName: PageBean
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Setter
@Getter
@ToString
public class PageBean<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	public PageBean(List<T> list, Integer count) {
		this.list = list;
		this.count = count == null ? 0 : count;
	}

	private List<T> list;

	private Integer page;

	private Integer pageSize;

	private Integer count;

}
