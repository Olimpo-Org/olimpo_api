FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests
 
FROM openjdk:17-jdk-slim
COPY --from=build /target/olimpo_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
