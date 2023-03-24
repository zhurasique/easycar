FROM openjdk:11-jre
ADD ./target/auth.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/auth.jar"]
EXPOSE 8800