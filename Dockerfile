FROM openjdk:17
EXPOSE 8080
ADD target/patient-hub-0.0.1-SNAPSHOT.jar patient-hub-0.0.1-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar", "/patient-hub-0.0.1-SNAPSHOT.jar" ]