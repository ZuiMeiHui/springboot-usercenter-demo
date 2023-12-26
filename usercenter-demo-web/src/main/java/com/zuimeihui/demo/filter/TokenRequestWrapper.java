package com.zuimeihui.demo.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.zuimeihui.demo.common.constants.Constants;

/**
 * 将用户信息放入Request中
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:51:27
 */
public class TokenRequestWrapper extends HttpServletRequestWrapper {

	private String token;

	private String userId;

	private String userName;

	TokenRequestWrapper(HttpServletRequest request, String token, String userId, String userName) {
		super(request);
		this.token = token;
		this.userId = userId;
		this.userName = userName;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		Enumeration<String> enumeration = super.getParameterNames();
		ArrayList<String> list = Collections.list(enumeration);
		list.add(Constants.USER_TOKEN_KEY);
		list.add(Constants.USER_ID_KEY);
		list.add(Constants.USER_NAME_KEY);
		return Collections.enumeration(list);
	}

	@Override
	public String[] getParameterValues(String name) {
		if (Constants.USER_TOKEN_KEY.equals(name)) {
			return new String[] { token };
		}
		if (Constants.USER_ID_KEY.equals(userId)) {
			return new String[] { userId };
		}
		if (Constants.USER_NAME_KEY.equals(userName)) {
			return new String[] { userName };
		}
		return super.getParameterValues(name);
	}

	@Override
	public String getParameter(String name) {
		if (Constants.USER_TOKEN_KEY.equals(name)) {
			return token;
		}
		if (Constants.USER_ID_KEY.equals(userId)) {
			return userId;
		}
		if (Constants.USER_NAME_KEY.equals(userName)) {
			return userName;
		}
		return super.getParameter(name);
	}

}
