FROM openjdk:8-alpine
ADD build/libs/docker-fun-api-0.0.1-SNAPSHOT.war .
EXPOSE 18080
CMD java -jar docker-fun-api-0.0.1-SNAPSHOT.war
