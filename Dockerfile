# Use amazon corretto JDK 17 alpine image as base image
FROM amazoncorretto:17-alpine-jdk

# Set working directory
WORKDIR /app

# Copy the packaged JAR file into the container at defined working directory
COPY target/order-management-0.0.1-SNAPSHOT.jar /app/order-management.jar

# Expose the port your application runs on
EXPOSE 8080

# Specify the command to run your application
CMD ["java", "-jar", "order-management.jar"]
