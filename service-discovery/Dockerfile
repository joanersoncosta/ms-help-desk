FROM openjdk

ARG JAR_FILE=./target/*.jar

EXPOSE 8761

COPY ${JAR_FILE} service-discovery-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "service-discovery-0.0.1-SNAPSHOT.jar"]