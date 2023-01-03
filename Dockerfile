FROM amazoncorretto:16-alpine-jdk
MAINTAINER ernestodominikow
COPY target/ed-0.0.1-SNAPSHOT.jar ed-0.0.1-SNAPSHOT.jar
ENTRYPOINT["java","-jar","/ed-0.0.1-SNAPSHOT.jar"]
