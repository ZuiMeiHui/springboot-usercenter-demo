package com.zuimeihui.demo.common.enums;

/**
 * 返回结果集枚举
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 11:00:52
 */
public enum BaseResultEnum {

	SUCCESS(0, "success"),

	FAIL(1, "fail"),

	NO_AUTH(403, "no auth");

	private final Integer code;

	private final String value;

	BaseResultEnum(Integer code, String value) {
		this.code = code;
		this.value = value;
	}

	public Integer getCode() {
		return code;
	}

	public String getValue() {
		return value;
	}
}
