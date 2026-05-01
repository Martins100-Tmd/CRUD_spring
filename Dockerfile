# Use Eclipse Temurin (official replacement for OpenJDK)
FROM eclipse-temurin:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy jar into container
COPY target/first-0.0.1-SNAPSHOT.jar app.jar

# Expose port (Spring Boot default)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]