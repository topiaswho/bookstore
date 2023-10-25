# Build stage
FROM maven:3.8.6-openjdk-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

# Package stage
FROM adoptopenjdk:17-jre-focal
COPY --from=build /home/app/target/bookstore.jar /usr/local/lib/bookstore.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/lib/bookstore.jar"]
