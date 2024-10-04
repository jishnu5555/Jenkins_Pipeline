# Use an official JDK runtime as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the WAR file from the Maven build
COPY target/coachwebspringapp-1.0-SNAPSHOT.war /app/app.war

# Expose port 8080 for the application
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.war"]
