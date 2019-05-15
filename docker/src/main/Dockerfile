FROM openjdk:8-jdk-alpine
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ARG JAR_FILE
ADD ${JAR_FILE} /opt/app.jar
WORKDIR /opt
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/opt/app.jar"]