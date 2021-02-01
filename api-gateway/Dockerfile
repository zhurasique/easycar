FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/api-gateway/src
COPY pom.xml /home/api-gateway
RUN mvn -f /home/api-gateway/pom.xml clean package


FROM openjdk:11-jre-slim
COPY --from=build /home/api-gateway/target/*.jar /usr/local/lib/api-gateway/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/api-gateway/app.jar"]