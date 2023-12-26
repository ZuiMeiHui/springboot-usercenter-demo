package com.zuimeihui.demo.service;

import org.springframework.stereotype.Service;

import com.zuimeihui.demo.dto.UserInfoDTO;

/**
 * 服务端API通用鉴权类
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:41:22
 */
@Service
public class OAuthService {

	/**
	 * 对Token鉴权
	 * 
	 * @param token
	 * @return
	 */
	public UserInfoDTO checkToken(String token) {
		// 例子，具体鉴权方法需根据用户接口自行实现
		UserInfoDTO userInfoDTO = new UserInfoDTO();
		userInfoDTO.setId(1L);
		userInfoDTO.setUserName("admin");
		return userInfoDTO;
	}
}
