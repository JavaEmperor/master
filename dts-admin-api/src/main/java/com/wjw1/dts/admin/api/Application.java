package com.wjw1.dts.admin.api;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = { "com.wjw1.dts.db", "com.wjw1.dts.core",
		"com.wjw1.dts.admin" })
@MapperScan({ "com.wjw1.dts.db.dao", "com.wjw1.dts.db.dao.ex" })
@EnableTransactionManagement
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}