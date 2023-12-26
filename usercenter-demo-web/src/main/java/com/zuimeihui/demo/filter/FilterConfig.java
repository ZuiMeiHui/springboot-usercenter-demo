package com.zuimeihui.demo.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注册过滤器
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:54:37
 */
@Configuration
public class FilterConfig {

	@Autowired
	private OAuthFilter oAuthFilter;

	/**
	 * 注册oAuthFilter过滤
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<OAuthFilter> registerAuthFilter() {
		FilterRegistrationBean<OAuthFilter> registration = new FilterRegistrationBean<OAuthFilter>();
		registration.setFilter(oAuthFilter);
		registration.setName("oAuthFilter");
		registration.setOrder(1);
		return registration;
	}

	// 如果有多个Filter, 复制上面Filter稍作修改，即可。
}
