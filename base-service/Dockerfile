FROM openjdk:11-jre
ADD ./target/base-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/base-service.jar"]
EXPOSE 8081