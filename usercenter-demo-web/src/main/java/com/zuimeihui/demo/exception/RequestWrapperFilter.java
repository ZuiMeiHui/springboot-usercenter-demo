package com.zuimeihui.demo.exception;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingRequestWrapper;

/**
 * 统一错误（Body）处理
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:56:36
 */
@Component
public class RequestWrapperFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			FilterChain filterChain) throws ServletException, IOException {
		filterChain.doFilter(new ContentCachingRequestWrapper(httpServletRequest), httpServletResponse);
	}

}
