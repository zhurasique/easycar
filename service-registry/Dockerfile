FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/service-regestry/src
COPY pom.xml /home/service-regestry
RUN mvn -f /home/service-regestry/pom.xml clean package


FROM openjdk:11-jre-slim
COPY --from=build /home/service-regestry/target/*.jar /usr/local/lib/service-regestry/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/service-regestry/app.jar"]