#从公共仓库下载java:8到本地容器
FROM java:8
#申明作者可以不写
MAINTAINER vincent.li vincentlee99@126.com
#WORKDIR：工作目录，类似于cd命令
#把maven打包好的jar拷贝到容器中并命名为app.jar
COPY target/springcloud-app-docker-java-helloworld.jar app.jar

#ENV：设置环境变量
ENV LANG C.UTF-8
#配置容器，使其可执行化。配合CMD可省去"application"，只使用参数。
ENTRYPOINT ["java", "-jar", "/app.jar"]
#EXPOSE：指定于外界交互的端口
EXPOSE 8080
#VOLUME：用于指定持久化目录