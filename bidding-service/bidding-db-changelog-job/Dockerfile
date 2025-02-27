FROM eclipse-temurin:21-jre-alpine

WORKDIR /opt

COPY target/*-exec.jar /opt/app.jar
ENTRYPOINT exec java $JAVA_OPTS -jar app.jar
