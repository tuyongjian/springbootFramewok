# dockerfile 基础配置
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /app/app.jar
WORKDIR /app/
EXPOSE 8889
ENTRYPOINT ["java","-jar","./app.jar"]
