FROM openjdk:11-jre
ADD ./target/config.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/config.jar"]
EXPOSE 8888