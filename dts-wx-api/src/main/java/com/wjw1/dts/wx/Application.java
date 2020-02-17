package com.wjw1.dts.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 服务启动类
 * 
 * @author CHENBO
 * @QQ:623659388
 */
@SpringBootApplication(scanBasePackages = { "com.wjw1.dts.db", "com.wjw1.dts.core",
		"com.wjw1.dts.wx" })
@MapperScan({ "com.wjw1.dts.db.dao", "com.wjw1.dts.db.dao.ex" })
@EnableTransactionManagement
@EnableScheduling
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
}