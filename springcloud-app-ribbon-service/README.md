## springcloud-app-ribbon-service
### 工程说明
* springcloud-app-ribbon-service只是服务消费者（rest+ribbon）(负载均衡)
 
### 运行说明
* 依赖springcloud-app-eureka-server来做服务注册与发现
* 依赖springcloud-app-eureka-client注册到注册中心提供的服务
* 启动顺序EurekaServerApplication-->EurekaClientApplication（可以修改端口号多启动几个服务实例）-->RibbonServiceApplication
* 浏览器打开链接 http://localhost:8761/可以看到SPRINGCLOUD-APP-EUREKA-CLIENT和SPRINGCLOUD-APP-RIBBON-SERVICE服务
* 浏览器打开http://localhost:8764/hi?name=vincent可以测试服务