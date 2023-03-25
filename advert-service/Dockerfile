FROM openjdk:11-jre
ADD ./target/advert-service.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/advert-service.jar"]
EXPOSE 8085