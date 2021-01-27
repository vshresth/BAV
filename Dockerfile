FROM openjdk:8
ARG JAR_FILE=target/swagger-spring-1.0.1.jar
ADD ${JAR_FILE} swagger-spring-1.0.1.jar
EXPOSE 8000
ENTRYPOINT ["java","-jar","/swagger-spring-1.0.1.jar"]