# Use the official OpenJDK 21 base image from Eclipse Temurin (AdoptOpenJDK)
FROM eclipse-temurin:21-jdk-focal

# Remove any default apps if you don't need them (optional)
RUN apt-get purge -y openjdk-*

# Install Apache Tomcat (for example) to serve the WAR file
RUN apt-get update && apt-get install -y wget && \
    wget https://archive.apache.org/dist/tomcat/tomcat-9/v9.0.62/bin/apache-tomcat-9.0.62.tar.gz && \
    tar -xvzf apache-tomcat-9.0.62.tar.gz && \
    mv apache-tomcat-9.0.62 /opt/tomcat

# Remove the WAR file from the previous Tomcat (if any)
RUN rm -rf /opt/tomcat/webapps/*

# Copy the WAR file from the Maven build output into the Tomcat webapps directory
COPY target/search-query-*.war /opt/tomcat/webapps/ROOT.war

# Expose port 8080 for the Tomcat server
EXPOSE 9090

# Run Tomcat when the container starts
CMD ["/opt/tomcat/bin/catalina.sh", "run"]