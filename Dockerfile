FROM openjdk:8 # FROM: 基础镜像，基于jdk8镜像开始

COPY *.jar /app.jar  # COPY: 将应用的配置文件也拷贝到镜像中。

CMD ["--server.port=8080"]

EXPOSE 8080  # EXPOSE：声明端口

ENTRYPOINT ["java","-jar","/app.jar"]
# ENTRYPOINT：docker启动时，运行的命令，这里容器启动时直接运行jar服务。