# Stage 1: Build stage using Maven
FROM maven:3.8.4-openjdk-17 AS build

WORKDIR /app

# Copy the POM file separately to leverage Docker's layer caching
COPY pom.xml .

# Copy all other project files
COPY . .

# Build the application with Maven
RUN mvn clean package -DskipTests

# Stage 2: Run stage using JDK slim image
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/web/target/*.jar app.jar

# Expose port 8080 (though not strictly necessary in this case)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.jar"]