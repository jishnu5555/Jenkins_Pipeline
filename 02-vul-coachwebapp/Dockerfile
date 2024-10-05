# Use an official Tomcat image with JDK 17
FROM tomcat:9.0-jdk17

# Remove default webapps to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file into Tomcat's webapps directory
COPY target/coachwebspringapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Copy the Datadog Java agent to the container
COPY dd-java-agent.jar /app/dd-java-agent.jar

# Expose Tomcat’s default port
EXPOSE 8080

# Set up the Datadog Java agent and run the application with Tomcat
ENTRYPOINT ["java", "-javaagent:/app/dd-java-agent.jar", "-Ddd.service=coachwebapp", "-Ddd.env=production", "-jar", "/usr/local/tomcat/webapps/ROOT.war"]
