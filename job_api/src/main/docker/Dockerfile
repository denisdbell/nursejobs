FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD job-api*.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTIONS=""
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTIONS -jar /app.jar" ]