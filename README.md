# springboot-usercenter-demo

## 介绍
本demo使用SpringBoot初始化的独立项目，与cas-service-demo和cas-client-demo配合使用的用户中心系统demo。  
已实现：用户列表显示，用户注册，用户信息修改，单个用户信息详情等功能，access_token已通过过滤器(filter)实现鉴权。

## 模块
本demo分为四个模块，common公共模块，dao数据模块，service服务模块，web控制模块，需使用Maven初始化。

## 业务demo
用户的增改查均已实现，带分页功能，入参校验需自行实现，物理删除功能需自行实现，逻辑删除可使用编辑接口。

## 运行
本demo可运行，启动web服务后，即可使用postman或其他方式测试接口。

## 端口
服务端口默认：8080

## 免责声明
本demo开源，共学习、交流、初始化项目使用，若使用后造成各种损失，与本demo和开发者无关。

## 附录-表结构

### 用户表
CREATE TABLE `user_info` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `time_create` datetime DEFAULT NULL COMMENT '创建时间',
  `time_update` datetime DEFAULT NULL COMMENT '更新时间',
  `admin_id` varchar(200) DEFAULT NULL COMMENT '操作人ID',
  `admin_name` varchar(200) DEFAULT NULL COMMENT '操作人登录名',
  `user_name` varchar(200) DEFAULT NULL COMMENT '登陆名称',
  `user_password` varchar(64) DEFAULT NULL COMMENT '登陆密码',
  `user_password_salt` varchar(8) DEFAULT NULL COMMENT '用户密码加盐',
  `user_nickname` varchar(200) DEFAULT NULL COMMENT '用户昵称',
  `user_telphone` varchar(100) DEFAULT NULL COMMENT '用户电话',
  `user_email` varchar(100) DEFAULT NULL COMMENT '用户邮箱',
  `user_remark` varchar(500) DEFAULT NULL COMMENT '用户备注',
  `user_freeze` tinyint DEFAULT NULL COMMENT '是否冻结，true，false',
  `user_del` tinyint DEFAULT NULL COMMENT '是否删除，true，false',
  PRIMARY KEY (`id`),
  UNIQUE KEY `system_user_UN` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

