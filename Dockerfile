# Use a base image with the Java runtime environment
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY build/libs/pb-0.0.1-SNAPSHOT.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

LABEL authors="pradeep"

# Set the command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]