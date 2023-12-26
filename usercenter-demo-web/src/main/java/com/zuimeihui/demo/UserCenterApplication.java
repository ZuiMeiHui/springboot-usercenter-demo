package com.zuimeihui.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 程序入口
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 10:37:30
 */
@SpringBootApplication(scanBasePackages = { "com.zuimeihui.demo" })
public class UserCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterApplication.class, args);
	}
}
