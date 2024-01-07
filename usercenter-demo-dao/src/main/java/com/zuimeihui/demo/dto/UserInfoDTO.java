package com.zuimeihui.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zuimeihui.demo.pojo.UserInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 用户表DTO
 * 
 * @ClassName: UserInfoDTO
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Setter
@Getter
@ToString
public class UserInfoDTO extends UserInfo {

	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@Override
	public String getUserPassword() {
		return userPassword;
	}

	@JsonIgnore
	@Override
	public String getUserPasswordSalt() {
		return userPasswordSalt;
	}

}