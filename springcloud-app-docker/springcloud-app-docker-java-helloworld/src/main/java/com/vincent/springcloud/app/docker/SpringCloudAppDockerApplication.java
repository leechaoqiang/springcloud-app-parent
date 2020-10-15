package com.vincent.springcloud.app.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * @author vincent.li
 * @Description api提供服务
 * @since 2019/6/29
 */
@SpringBootApplication(scanBasePackages = {"com.vincent.springcloud.app"})
public class SpringCloudAppDockerApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringCloudAppDockerApplication.class, args);
        System.out.println("(#^.^#)   【SpringCloud-docker-app-hello-world】启动成功      (#^.^#)");
    }
}
