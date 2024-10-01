FROM openjdk

ARG JAR_FILE=./build/libs/*.jar

EXPOSE 8080

COPY ${JAR_FILE} helpdesk-bff.jar

ENTRYPOINT ["java", "-jar", "helpdesk-bff.jar"]