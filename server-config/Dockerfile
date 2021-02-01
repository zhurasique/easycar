FROM maven:3.6.0-jdk-11-slim AS build
COPY src /home/server-config/src
COPY pom.xml /home/server-config
RUN mvn -f /home/server-config/pom.xml clean package


FROM openjdk:11-jre-slim
COPY --from=build /home/server-config/target/*.jar /usr/local/lib/server-config/app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/server-config/app.jar"]