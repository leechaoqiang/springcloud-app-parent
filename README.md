## springcloud-app-parent
### 工程说明
* springcloud-app-parent是一个SpringCloud的练习实践项目
* Spring Cloud版本号是Greenwich.SR3
* Spring Boot的版本号是2.1.15.RELEASE
### 模块说明
1. springcloud-app-eureka-server  eureka做服务注册与发现中心
2. springcloud-app-eureka-client  注册服务（可供消费）
3. springcloud-app-config-server  分布式服务配置中心-配置服务提供者
4. springcloud-app-config-client  分布式服务配置中心-配置服务消费者
5. springcloud-app-ribbon-service 服务消费者（rest+ribbon）(负载均衡)
6. springcloud-app-common 公共模块
7. springcloud-app-gateway 网关使用demo （使用nacos做注册发现）
8. springcloud-app-api 网关代理api服务 （使用nacos做注册发现）
9. springcloud-app-kafka kafka消息生产消费的实践 
    - 9.1 springcloud-app-kafka-producer kafka消息生产
    - 9.2 springcloud-app-kafka-consumer kafka消息消费 
10. springcloud-app-rabbitmq rabbitmq消息生产消费的实践
    - 10.1 springcloud-app-rabbitmq-producer rabbitmq消息生产
    - 10.2 springcloud-app-rabbitmq-consumer rabbitmq消息消费
11. springcloud-app-docker Docker打包springboot应用实践
    - 11.1 springcloud-app-docker-java-helloworld docker打包java的helloworld应用实践
12. springcloud-app-feign-client feign调用实践（使用nacos做注册发现，和springcloud-app-api配合使用）
13. springcloud-app-seata 分布式事物seata实践   
14. springcloud-app-rocketmq rocketmq消息生产消费的实践
    - 14.1 springcloud-app-rocketmq-producer rocketmq消息生产
    - 14.2 springcloud-app-rocketmq-consumer rocketmq消息消费