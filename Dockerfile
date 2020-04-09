FROM openjdk:13
VOLUME /tmp
ADD target/graph-0.0.1-SNAPSHOT.jar graph-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","graph-0.0.1-SNAPSHOT.jar"]