FROM openjdk:17-slim as build

COPY target/carservice-0.0.1-SNAPSHOT.jar carservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "carservice-0.0.1-SNAPSHOT.jar"]