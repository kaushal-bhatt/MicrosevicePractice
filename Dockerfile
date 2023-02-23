FROM openjdk:19-jdk-alpine3.15
ENV JAVA_HOME /opt/openjdk-17
ENV PATH $JAVA_HOME/bin:$PATH
ENV JAVA_VERSION 17-ea+14
ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'

ARG JAVA_OPTS
ENV JAVA_OPTS=$JAVA_OPTS
COPY --chown=185 target/licensing-service-0.0.1-SNAPSHOT.jar /deployments/licensing-service-0.0.1-SNAPSHOT.jar
EXPOSE 8080

CMD ["java", "-jar", "/deployments/licensing-service-0.0.1-SNAPSHOT.jar"]