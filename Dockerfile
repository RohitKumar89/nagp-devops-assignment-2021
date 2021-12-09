FROM amazoncorretto:8-alpine3.12

COPY target/nagp-assignment.jar /var/lib/nagp-assignment.jar

EXPOSE 8086

ENTRYPOINT ["java", "-jar", "/var/lib/nagp-assignment.jar" ]