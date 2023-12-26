package com.zuimeihui.demo.service.ddl;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * db_usercenter库 - 数据库配置
 * 
 * @author 醉美会 ZuiMeiHui.com
 * @date 2023-11-18 11:17:35
 */
@Configuration
@MapperScan(basePackages = { "com.zuimeihui.demo.dao", "com.zuimeihui.demo.dao.*" }, sqlSessionFactoryRef = "dbUserCenterSqlSessionFactory")
public class UserCenterConfig {

	@Primary 
	@Bean("dbUserCenterDataSource")
	@ConfigurationProperties(prefix = "spring.datasource.usercenter")
	public DataSource getUserDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Primary
	@Bean("dbUserCenterSqlSessionFactory")
	public SqlSessionFactory userSqlSessionFactory(@Qualifier("dbUserCenterDataSource") DataSource dataSource) throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
		bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*.xml"));
		return bean.getObject();
	}

	@Primary
	@Bean("dbUserCenterSqlSessionTemplate")
	public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("dbUserCenterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}
}
