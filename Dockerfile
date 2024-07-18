FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ADD ./target/employee-api-0.0.1-SNAPSHOT.jar employee-api.jar

ENTRYPOINT ["java", "-jar", "/employee-api.jar"]