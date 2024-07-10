FROM gradle:8.8-jdk-21-and-22 AS build

COPY src /app/src
COPY build.gradle /app

WORKDIR /app

RUN gradle build --no-daemon

FROM openjdk:21-slim

COPY --from=build /app/build/libs/*.jar /app/spring-boot-application.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "spring-boot-application.jar"]
