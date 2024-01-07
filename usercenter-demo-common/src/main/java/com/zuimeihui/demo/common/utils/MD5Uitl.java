package com.zuimeihui.demo.common.utils;

import org.apache.shiro.crypto.hash.ConfigurableHashService;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

/**
 * 生成用户密码
 * 
 * @ClassName: MD5Uitl
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
public class MD5Uitl {

	public static String encode(String userPassword, String userPasswordSalt) {
		ConfigurableHashService hashService = new DefaultHashService();
		hashService.setPrivateSalt(ByteSource.Util.bytes("ZuiMeiHui.com"));
		hashService.setHashAlgorithmName("MD5");
		hashService.setHashIterations(1);
		HashRequest request = new HashRequest.Builder().setSalt(userPasswordSalt).setSource(userPassword).build();
		return hashService.computeHash(request).toHex();
	}

}
