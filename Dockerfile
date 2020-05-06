FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
VOLUME /tmp
EXPOSE 8090
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD ${JAR_FILE} /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Dspring.profiles.active=container", "-jar", "/app/app.jar"]
