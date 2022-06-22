# springcloud-app-seata
> seata分布式事物AT模式的实践

## 部署准备

### 安装seata-server
#### 直接部署
   1. 在[https://github.com/seata/seata/releases](RELEASE)页面下载相应版本并解压
   2. 直接启动
* 在 Linux/Mac下执行如下命令

```shell
$ sh ./bin/seata-server.sh

```
* 在 Windows 下
```shell
 bin\seata-server.bat

```

#### 支持的启动参数
|参数|	全写 |	作用 |	备注 |
|----|----|----|----|
|-h	|--host	|指定在注册中心注册的 IP	| 不指定时获取当前的 IP，外部访问部署在云环境和容器中的 server 建议指定| 
|-p	|--port	|指定 server 启动的端口	| 默认为 8091|
|-m	|--storeMode	| 事务日志存储方式 |	支持file,db,redis，<br>默认为 file 注:redis需seata-server 1.3版本及以上|
|-n	|--serverNode	| 用于指定seata-server节点ID | 	如 1,2,3..., 默认为 1 |
|-e	|--seataEnv	| 指定 seata-server <br>运行环境	| 如 dev, test 等, 服务启动时会使用<br>registry-dev.conf 这样的配置 |

* 如(如果你用eureka作为注册中心,请先启动springcloud-app-seata-eureka服务)：
```shell
$ sh ./bin/seata-server.sh -p 8091 -h 127.0.0.1 -m file

```

## 执行SQL脚本

请分别创建三个数据库，然后执行[./docs/app-seata.sql](app-seata.sql脚本)

## 修改各应用服务的application.yaml配置

## 运行测试
* 1. 启动各应用服务
* 2. 在浏览器中输入[http://localhost:8761/](http://localhost:8761/)地址查看各应用的启动注册情况
* 3. 然后post请求http://localhost:8083/order/create,请求参数如下：

    ```json
    {
    "id": "PO202103020002",
    "userId": 1,
    "productId": 1,
    "count": 3,
    "money": 48.98
    }
    ```
* 4. 然后可以测试创建订单时库存不够或者账户余额不够等场景，服务集体回滚等分布式事物控制场景。  
    



