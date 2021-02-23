FROM openjdk:8
MAINTAINER Vivek Shrestha <vivek.shrestha@swift.com>
ARG JAR_FILE=target/swift-gpi-bav.jar
ADD ${JAR_FILE} swift-gpi-bav.jar
ENTRYPOINT ["java","-jar","/swift-gpi-bav.jar"]