package com.vincent.springcloud.app.seata.eureka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SeataEurekaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeataEurekaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O(∩_∩)O哈哈~    【SeataEurekaApplication】启动成功      O(∩_∩)O哈哈~");
	}
}
