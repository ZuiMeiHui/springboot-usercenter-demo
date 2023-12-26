package com.zuimeihui.demo.filter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zuimeihui.demo.common.constants.Constants;
import com.zuimeihui.demo.common.enums.BaseResultEnum;
import com.zuimeihui.demo.common.service.BaseResult;
import com.zuimeihui.demo.service.OAuthService;

/**
 * 鉴权过滤器
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:52:54
 */
@WebFilter(filterName = "OAuthFilter", urlPatterns = "/*")
@Component
public class OAuthFilter implements Filter {
	
	@Autowired
	private OAuthService oAuthService;
	
	/**
	 * 免鉴权接口
	 */
	private static String[] ignoreURI = {
			"/main.htm" // 健康检查
	};
	
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	/**
	 * 开始API接口鉴权，通过鉴权的用户信息放入Request中，方便接口直接使用
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getServletPath();
		String token = req.getHeader(Constants.USER_TOKEN_KEY);
		String userId = null;
		String userName = null;
		Boolean isIgnoreUrl = false;
		if (ignoreURI != null && ignoreURI.length > 0) {
			for (String ignore : ignoreURI) {
				if (Pattern.matches(ignore,  uri)) {
					isIgnoreUrl = true;
					userId = "0";
					userName = "unknown";
				}
			}
		}
		userId = oAuthService.checkToken(token).getId().toString();
		userName = oAuthService.checkToken(token).getUserName();
		if (!isIgnoreUrl) {
			if (StringUtils.isBlank(token) || StringUtils.isBlank(userId) || StringUtils.isBlank(userName)) {
				noAuthMsg(req, response);
				return ;
			}
		}
		chain.doFilter(new TokenRequestWrapper(req, token, userId, userName), response);
	}
	
	@Override
	public void destroy() {
		
	}
	
	/**
	 * 鉴权验证失败，返回403
	 * @param request
	 * @param response
	 */
	private void noAuthMsg(HttpServletRequest request, ServletResponse response) {
		HttpServletResponse resp = (HttpServletResponse) response;
		resp.setContentType("application/json; charset=utf-8");
		resp.setStatus(403);
		PrintWriter writer = null;
		OutputStreamWriter osw = null;
		try {
			osw = new OutputStreamWriter(resp.getOutputStream(), "UTF-8");
			writer = new PrintWriter(osw, true);
			BaseResult<?> result = BaseResult.fail(BaseResultEnum.NO_AUTH.getValue());
			ObjectMapper objectMapper = new ObjectMapper();
			String jsonStr = objectMapper.writeValueAsString(result);
			writer.write(jsonStr);
			writer.flush();
			writer.close();
			osw.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				writer.close();
			}
			if (osw != null) {
				try {
					osw.close();
				} catch (IOException e) {
					
				}
			}
		}
	}
	
}
 