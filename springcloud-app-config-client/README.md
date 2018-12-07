## springcloud-app-config-client
### 工程说明
* springcloud-app-config-client只是配置中心服务的消费者
 
### 运行说明
* 依赖springcloud-app-eureka-server来做服务注册与发现
* 依赖springcloud-app-config-server注册到注册中心提供的服务
* 启动顺序EurekaServerApplication-->ConfigServerApplication-->ConfigClientApplication
* 浏览器打开链接 http://localhost:8761/可以看到SPRINGCLOUD-APP-CONFIG-SERVER和SPRINGCLOUD-APP-CONFIG-CLIENT服务
* 浏览器打开http://localhost:8888/springcloud-app-config-client-dev.yml可以查看dev环境下配置文档的内容
* 浏览器打开http://localhost:8080/message可以测试配置服务中拉取到的配置内容
