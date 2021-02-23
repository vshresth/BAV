FROM openjdk:8
MAINTAINER Vivek Shrestha <vivek.shrestha@swift.com>
ARG JAR_FILE=target/swift-gpi-bav-1.0.1.jar
ADD ${JAR_FILE} swift-gpi-bav-1.0.1.jar
ENTRYPOINT ["java","-jar","/swift-gpi-bav-1.0.1.jar"]