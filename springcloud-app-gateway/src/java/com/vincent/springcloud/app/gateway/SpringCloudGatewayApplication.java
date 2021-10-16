package com.vincent.springcloud.app.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.util.TimeZone;

import static com.vincent.springcloud.app.common.constants.SystemConstants.APP_API;
import static com.vincent.springcloud.app.common.constants.SystemConstants.APP_FEIGN;

/**
 * @author vincent.li
 * @Description 网关启动类
 * @since 2019/6/29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudGatewayApplication {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(SpringCloudGatewayApplication.class, args);
        System.out.println("(#^.^#)   【SpringCloud-app-gateway】启动成功      (#^.^#)");
    }

    /**
     * 硬编码方式网关路由
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("api_route", p -> p.path(APP_API +"/**").filters(f -> f.removeRequestHeader("Expect"))
                        .uri("lb://springcloud-app-api"))
                .route("feign_client_route", p -> p.path(APP_FEIGN +"/**").filters(f -> f.removeRequestHeader("Expect"))
                    .uri("lb://springcloud-app-feign-client"))
                .build();
    }
}
