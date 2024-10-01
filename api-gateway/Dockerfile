FROM openjdk

ARG JAR_FILE=./target/*.jar

EXPOSE 8765

COPY ${JAR_FILE} api-gateway.jar

ENTRYPOINT ["java", "-jar", "api-gateway.jar"]