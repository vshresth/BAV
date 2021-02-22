FROM openjdk:8
MAINTAINER Vivek Shrestha <vivek.shrestha@swift.com>
ARG JAR_FILE=target/swift-gpi-bav-1.0.0.jar
ADD ${JAR_FILE} swift-gpi-bav-1.0.0.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/swift-gpi-bav-1.0.0.jar"]