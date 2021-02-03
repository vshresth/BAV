FROM tomcat:latest
ARG JAR_FILE=target/swagger-spring-1.0.4.war
ADD ${JAR_FILE} /usr/local/tomcat/webapps/swagger-spring-1.0.4.war
EXPOSE 8001
CMD ["catalina.sh", "run"]
#ENTRYPOINT ["java","-jar","/swagger-spring-1.0.3.war"]