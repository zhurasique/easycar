FROM openjdk:11-jre
ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]
EXPOSE 9191