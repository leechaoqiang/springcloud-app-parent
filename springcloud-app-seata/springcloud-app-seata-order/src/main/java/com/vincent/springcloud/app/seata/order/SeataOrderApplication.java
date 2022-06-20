package com.vincent.springcloud.app.seata.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 订单服务
 * @author vincent.li
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.vincent.springcloud.app.seata.order.dao")
@EnableDiscoveryClient
@EnableFeignClients
public class SeataOrderApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeataOrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O(∩_∩)O~    【SeataOrderApplication】启动成功      O(∩_∩)O~");

	}
}
