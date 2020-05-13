FROM openjdk:15-ea-10-jdk-alpine3.11
ADD build/libs/docker-fun-api-0.0.1-SNAPSHOT.jar .
EXPOSE 18080
CMD java -jar docker-fun-api-0.0.1-SNAPSHOT.jar
