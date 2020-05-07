FROM openjdk:8-jdk-alpine
FROM maven
VOLUME /tmp
EXPOSE 8090
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
RUN cd . mvn clean install
ADD target/SMI-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/ ./urandom", "-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
