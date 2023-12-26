package com.zuimeihui.demo.service;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-12 20:03:09
 */
public class RequestLoggingInterceptor implements ClientHttpRequestInterceptor {
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
		ClientHttpResponse response = execution.execute(request, body);
		return response;
	}
	
}
