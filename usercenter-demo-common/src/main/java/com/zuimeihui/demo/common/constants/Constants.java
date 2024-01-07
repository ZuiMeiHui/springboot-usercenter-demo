package com.zuimeihui.demo.common.constants;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 常量
 * 
 * @ClassName: Constants
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
public class Constants {

	// 鉴权
	public static final String CAS_OAUTH_SERVICE = "https://cas.zuimeihui.com:88/cas/oauth2.0";

	// 账号
	public static final String USER_TOKEN_KEY = "access_token";
	public static final String USER_ID_KEY = "USER_ID_KEY";
	public static final String USER_NAME_KEY = "USER_NAME_KEY";

	// 默认分页每页记录数
	public static final Integer PAGE_SIZE = 20;

	// 线程池
	public static final ThreadPoolExecutor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(1, 100, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(100));

}
