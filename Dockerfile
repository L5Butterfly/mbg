#获取base image
#FROM adoptopenjdk/openjdk8:latest
# 引用jdk8
FROM java:8
# 拷贝jar到应用目录
COPY *.jar mbg.jar
# 指定应用启动端口
CMD ["--server.port=8080"]
# 对外暴露的端口
EXPOSE 8080
# 执行命令 java -jar mbg.jar.jar
ENTRYPOINT ["java", "-jar", "/mbg.jar"]