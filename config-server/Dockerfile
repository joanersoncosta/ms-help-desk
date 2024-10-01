FROM openjdk

ARG JAR_FILE=./target/*.jar

EXPOSE 8888

COPY ${JAR_FILE} config-server.jar

ENTRYPOINT ["java", "-jar", "config-server.jar"]