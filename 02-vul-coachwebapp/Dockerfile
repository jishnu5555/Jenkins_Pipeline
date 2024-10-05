# Use an official Tomcat image with JDK 17
FROM tomcat:9.0-jdk17

# Remove default webapps to avoid conflicts
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy the WAR file into Tomcat's webapps directory
COPY target/coachwebspringapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat’s default port
EXPOSE 8080

# Run Tomcat
CMD ["catalina.sh", "run"]
