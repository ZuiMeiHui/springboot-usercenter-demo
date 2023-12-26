package com.zuimeihui.demo.common.service;

import java.io.Serializable;

import com.zuimeihui.demo.common.enums.BaseResultEnum;

/**
 * API接口，返回结果集
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-12-03 10:33:47
 */
public class ApiResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;

	private String message;

	private T data;

	public ApiResult(Integer code, String message, T data) {
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public Boolean isSuccess() {
		return code == BaseResultEnum.SUCCESS.getCode();
	}

	public Boolean isFail() {
		return code != BaseResultEnum.SUCCESS.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public T getData() {
		return data;
	}
}
