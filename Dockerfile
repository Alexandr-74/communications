FROM openjdk:17-jdk-alpine
WORKDIR /spring
COPY build/libs/communications-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","communications-0.0.1-SNAPSHOT.jar"]
