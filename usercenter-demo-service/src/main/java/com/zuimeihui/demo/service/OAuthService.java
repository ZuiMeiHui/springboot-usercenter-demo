package com.zuimeihui.demo.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson2.JSONObject;
import com.zuimeihui.demo.common.constants.Constants;
import com.zuimeihui.demo.dto.UserInfoDTO;
import com.zuimeihui.demo.dto.UserInfoQueryDTO;
import com.zuimeihui.demo.service.user.UserInfoService;

/**
 * 服务端API通用鉴权类
 * 
 * @ClassName: OAuthService
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@Service
public class OAuthService {

	@Autowired
	private UserInfoService UserInfoService;

	/**
	 * 对登陆accessToken鉴权
	 * 
	 * @Title: checkToken
	 * @Description: TODO
	 * @param @param  token
	 * @param @return 参数
	 * @return UserInfoDTO 返回类型
	 * @throws
	 * @author ZuiMeiHui.com 醉美会
	 */
	public UserInfoDTO checkAccessToken(String accessToken) {
		String responseBody = null;
		String url = Constants.CAS_OAUTH_SERVICE + "/profile?access_token=" + accessToken;
		RestTemplateCustom restTemplateCustom = new RestTemplateCustom();
		try {
			ResponseEntity<String> response = restTemplateCustom.getForEntity(url, String.class);
			responseBody = response.getBody();
		} catch (Exception e) {
			return null;
		}
		if (StringUtils.isBlank(responseBody)) {
			return null;
		}
		JSONObject jsonObject = JSONObject.parseObject(responseBody);
		if (jsonObject == null) {
			return null;
		}
		String id = jsonObject.getString("id");
		if (StringUtils.isBlank(id)) {
			return null;
		}
		UserInfoQueryDTO userInfoQueryDTO = new UserInfoQueryDTO();
		userInfoQueryDTO.setUserName(id);
		userInfoQueryDTO.setUserFreeze(false);
		userInfoQueryDTO.setUserDel(false);
		List<UserInfoDTO> userInfoDTOs = UserInfoService.selectBy(userInfoQueryDTO);
		if (userInfoDTOs == null || userInfoDTOs.isEmpty()) {
			return null;
		}
		return userInfoDTOs.get(0);
	}
}
