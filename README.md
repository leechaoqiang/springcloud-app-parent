## springcloud-app-parent
### 工程说明
* springcloud-app-parent是一个练习SpringCloud的demo工程
* Spring Cloud版本号是Greenwich.SR3
* Spring Boot的版本号是2.1.10.RELEASE
### 模块说明
* springcloud-app-eureka-server  eureka做服务注册与发现中心
* springcloud-app-eureka-client  注册服务（可供消费）
* springcloud-app-config-server  分布式服务配置中心-配置服务提供者
* springcloud-app-config-client  分布式服务配置中心-配置服务消费者
* springcloud-app-ribbon-service 服务消费者（rest+ribbon）(负载均衡)
* springcloud-app-common 公共模块
* springcloud-app-gateway 网关使用demo （使用nacos做注册发现）
* springcloud-app-api 网关代理api服务 （使用nacos做注册发现）
