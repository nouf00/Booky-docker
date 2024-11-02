FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/booky-bakend-0.0.1-SNAPSHOT.jar booky-bakend-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "booky-bakend-0.0.1-SNAPSHOT.jar"]
