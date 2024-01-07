package com.zuimeihui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * 
 * @ClassName: UserCenterApplication
 * @Description: TODO
 * @author ZuiMeiHui.com 醉美会
 */
@SpringBootApplication(scanBasePackages = { "com.zuimeihui.demo" })
public class UserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterApplication.class, args);
	}
}
