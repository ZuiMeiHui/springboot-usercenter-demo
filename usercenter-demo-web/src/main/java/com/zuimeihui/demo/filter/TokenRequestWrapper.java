package com.zuimeihui.demo.filter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.zuimeihui.demo.common.constants.Constants;

/**
 * 将用户关键信息放入Request中
 * 
 * @ClassName: TokenRequestWrapper
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
public class TokenRequestWrapper extends HttpServletRequestWrapper {

	private String accessToken;

	private String userId;

	private String userName;

	TokenRequestWrapper(HttpServletRequest request, String accessToken, String userId, String userName) {
		super(request);
		this.accessToken = accessToken;
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
			return new String[] { accessToken };
		}
		if (Constants.USER_ID_KEY.equals(name)) {
			return new String[] { userId };
		}
		if (Constants.USER_NAME_KEY.equals(name)) {
			return new String[] { userName };
		}
		return super.getParameterValues(name);
	}

	@Override
	public String getParameter(String name) {
		if (Constants.USER_TOKEN_KEY.equals(name)) {
			return accessToken;
		}
		if (Constants.USER_ID_KEY.equals(name)) {
			return userId;
		}
		if (Constants.USER_NAME_KEY.equals(name)) {
			return userName;
		}
		return super.getParameter(name);
	}

}
