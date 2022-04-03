####
# Native
#
FROM quay.io/quarkus/ubi-quarkus-native-s2i:22.0-java17 AS builder

COPY . /home/quarkus/
RUN ./mvnw clean package -Pnative

FROM quay.io/quarkus/quarkus-micro-image:1.0

WORKDIR /work/
COPY --from=builder /home/quarkus/target/*-runner /work/application

EXPOSE 8080
USER 1001

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]
