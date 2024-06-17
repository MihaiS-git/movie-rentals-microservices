# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /gateway

# Add the application JAR file to the container
COPY build/libs/Gateway-0.0.1-SNAPSHOT.jar gateway.jar

# Expose the port that the application will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "gateway.jar"]
