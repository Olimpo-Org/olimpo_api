# Build package

FROM maven:3.8.3-openjdk-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package
RUN ls -l /app/target  # Este comando lista os arquivos no diretório target

# Stage package

FROM openjdk:17-jdk-slim
COPY --from=build /target/olimpo_api-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
