FROM frolvlad/alpine-oraclejdk8:latest
ADD docker-1.0-SNAPSHOT.jar app.jar
EXPOSE 8013
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "sh", "-c", "java -jar /app.jar" ]