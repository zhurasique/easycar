FROM java:8-jre
ADD ./target/location-service.jar /app/
CMD ["java", "-Xmx400m", "-jar", "/app/location-service.jar"]
EXPOSE 8083