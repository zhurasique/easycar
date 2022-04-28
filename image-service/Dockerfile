FROM java:8-jre
ADD ./target/image-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/image-service.jar"]
EXPOSE 8082