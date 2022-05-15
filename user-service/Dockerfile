FROM java:8-jre
ADD ./target/user-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/user-service.jar"]
EXPOSE 8084