FROM openjdk:17-jdk-alpine
EXPOSE 9095

VOLUME /tmp

COPY src/main/java/ubb/movierentals/grpc /app/libs

ADD build/libs/RentalEntity-0.0.1-SNAPSHOT.jar rentalentity.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/rentalentity.jar"]
