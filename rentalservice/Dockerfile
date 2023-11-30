FROM openjdk:17-slim as build

COPY target/rentalservice-0.0.1-SNAPSHOT.jar rentalservice-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "rentalservice-0.0.1-SNAPSHOT.jar"]