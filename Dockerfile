# Use an official OpenJDK runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory
WORKDIR /usr/src/app

# Copy the JAR file to the container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the app runs on
EXPOSE 8080

# Define the command to run the app
CMD ["java", "-jar", "app.jar"]
