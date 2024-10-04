# Build package

FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests -X

# Stage package

FROM openjdk:17-jdk-slim
COPY --from=build app/target/olimpo_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
