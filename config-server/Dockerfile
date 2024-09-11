FROM openjdk

ARG JAR_FILE=./target/*.jar

EXPOSE 8888

COPY ${JAR_FILE} config-server-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java", "-jar", "config-server-0.0.1-SNAPSHOT.jar"]