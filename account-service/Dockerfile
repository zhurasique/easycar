FROM openjdk:11-jre
ADD ./target/account-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/account-service.jar"]
EXPOSE 8084