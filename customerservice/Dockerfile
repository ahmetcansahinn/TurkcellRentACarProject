FROM openjdk:17-slim as build

COPY target/customerservice-0.0.1-SNAPSHOT.jar customerservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "customerservice-0.0.1-SNAPSHOT.jar"]