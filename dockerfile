FROM openjdk:22-jdk-slim

WORKDIR /app

COPY ./target/family.jar family.jar
EXPOSE 8080

ENTRYPOINT ["java","-jar", "family.jar"]