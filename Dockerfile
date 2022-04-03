####
# JVM
#
FROM registry.access.redhat.com/ubi8/openjdk-11:1.11 AS builder

COPY . /home/jboss/
RUN ./mvnw clean package

FROM registry.access.redhat.com/ubi8/openjdk-11:1.11

ENV LANG='en_US.UTF-8' LANGUAGE='en_US:en'
ENV JAVA_OPTS="-Dquarkus.http.host=0.0.0.0 -Djava.util.logging.manager=org.jboss.logmanager.LogManager"
ENV JAVA_APP_JAR="/deployments/quarkus-run.jar"

COPY --from=builder /home/jboss/target/quarkus-app/lib/ /deployments/lib/
COPY --from=builder /home/jboss/target/quarkus-app/*.jar /deployments/
COPY --from=builder /home/jboss/target/quarkus-app/app/ /deployments/app/
COPY --from=builder /home/jboss/target/quarkus-app/quarkus/ /deployments/quarkus/
