FROM openjdk:17-jdk-alpine
EXPOSE 9096

VOLUME /tmp
ADD build/libs/ClientEntity-0.0.1-SNAPSHOT.jar cliententity.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/cliententity.jar"]
