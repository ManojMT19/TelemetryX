FROM eclipse-temurin:25-jdk

WORKDIR /app

COPY target/TelemetryX.jar TelemetryX.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "TelemetryX.jar"]