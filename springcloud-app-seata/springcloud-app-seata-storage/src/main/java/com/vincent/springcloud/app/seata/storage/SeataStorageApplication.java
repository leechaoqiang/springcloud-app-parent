package com.vincent.springcloud.app.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @author vincent.li
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.vincent.springcloud.app.seata.storage.dao")
public class SeataStorageApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SeataStorageApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("O(∩_∩)O哈哈~    【SeataStorageApplication】启动成功      O(∩_∩)O哈哈~");

	}
}
