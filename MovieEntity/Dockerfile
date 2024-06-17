FROM openjdk:17-jdk-alpine

EXPOSE 9097
EXPOSE 9092

VOLUME /tmp
ADD build/libs/MovieEntity-0.0.1-SNAPSHOT.jar movieentity.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/movieentity.jar"]
