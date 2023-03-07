FROM openjdk:11-slim

LABEL maintainer="Kaushal Bhatt <kaushalbhatt8650@gmail.com>"

ARG JAR_FILE=target/licensing-service-0.0.1-SNAPSHOT.jar
COPY --chown=185 ${JAR_FILE} licensing-service-0.0.1-SNAPSHOT.jar

#RUN mkdir -p target/dependency &&  (cd target/dependency; jar -xf /licensing-service-0.0.1-SNAPSHOT.jar)
#
#FROM openjdk:11-slim
##
#VOLUME /tmp
##
#
#WORKDIR /app
#
#ARG DEPENDENCY=/target/dependency
#COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
#COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
CMD ["java", "-jar", "licensing-service-0.0.1-SNAPSHOT.jar"]
#ENTRYPOINT ["java","-cp","app:app/lib/*","com.microservice.license.SpringbootActionBookApplication"]

#ENV JAVA_HOME /opt/openjdk-17
#ENV PATH $JAVA_HOME/bin:$PATH
#ENV JAVA_VERSION 17-ea+14
#ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'
#
#ARG JAVA_OPTS
#ENV JAVA_OPTS=$JAVA_OPTS
#COPY --chown=185 target/licensing-service-0.0.1-SNAPSHOT.jar /deployments/licensing-service-0.0.1-SNAPSHOT.jar
#EXPOSE 8080
#
#CMD ["java", "-jar", "/deployments/licensing-service-0.0.1-SNAPSHOT.jar"]