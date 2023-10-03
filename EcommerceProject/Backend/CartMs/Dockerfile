# Fetching latest version of Java
FROM openjdk:18

# Setting up work directory
WORKDIR /app



# Copy the jar file into work directory
COPY ./target/CartMs-0.0.1-SNAPSHOT.jar /app



# Exposing port 8085
EXPOSE 8085



# Starting the application
CMD ["java", "-jar", "CartMs-0.0.1-SNAPSHOT.jar"]