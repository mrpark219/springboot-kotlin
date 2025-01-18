FROM openjdk:17

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=build/libs/springboot-kotlin-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} springboot-kotlin-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom", "-jar", "/springboot-kotlin-0.0.1-SNAPSHOT.jar"]
