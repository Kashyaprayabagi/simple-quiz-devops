# Step 1: Use Maven to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Step 2: Use JDK to run the app
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=builder /app/target/quiz-backend-1.0.jar app.jar
EXPOSE 8081
CMD ["java", "-jar", "app.jar"]
