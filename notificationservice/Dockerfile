FROM openjdk:17-slim as build

COPY target/notificationservice-0.0.1-SNAPSHOT.jar notificationservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "notificationservice-0.0.1-SNAPSHOT.jar"]