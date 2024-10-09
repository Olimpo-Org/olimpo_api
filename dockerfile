# Etapa de build usando Maven
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package
RUN ls -l /app/target  # Adicione esta linha

# Etapa Final
FROM openjdk:17-jdk-slim
COPY --from=build /app/target/olimpo_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
