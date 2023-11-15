FROM openjdk:11
ARG JAR_FILE=target/*.war
COPY target/*.war app.war
ENTRYPOINT ["java","-jar","/app.war"]
EXPOSE 8080