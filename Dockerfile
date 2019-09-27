FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/family.jar app.jar
ENTRYPOINT ["java","-jar","family.jar"]
 
