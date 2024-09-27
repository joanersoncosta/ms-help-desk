FROM openjdk

ARG JAR_FILE=./target/*.jar

EXPOSE 8761

COPY ${JAR_FILE} service-discovery.jar

ENTRYPOINT ["java", "-jar", "service-discovery.jar"]