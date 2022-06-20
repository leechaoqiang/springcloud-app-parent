package com.vincent.springcloud.app.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author vincent.li
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.vincent.springcloud.app.seata.account.dao")
@EnableDiscoveryClient
public class SeataAccountApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeataAccountApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O(∩_∩)O哈哈~    【SeataAccountApplication】启动成功      O(∩_∩)O哈哈~");
	}
}
