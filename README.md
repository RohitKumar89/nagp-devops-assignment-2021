# nagp-devops-assignment-2021
This is DevOps Assignment for NAGP 2021
1. Use MySQL Image published by Docker Hub (https://hub.docker.com/_/mysql/)
Command to run the mysql container
`docker run --name mysql-standalone -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -e MYSQL_USER=sa -e MYSQL_PASSWORD=password -d mysql:5.6`

2. In the nagp-devops-assignment-2021, use the same container name of the mysql instance in the application.properties
ex - `spring.datasource.url = jdbc:mysql://mysql-standalone:3306/test`

3. Create a `Dockerfile` for creating a docker image from the nagp-devops-assignment-2021, exposing 8086 port to run application because on 8080 jenkins is running <br>
`FROM amazoncorretto:8-alpine3.12`
`COPY target/nagp-assignment.jar /var/lib/nagp-assignment.jar`
`EXPOSE 8086`
`ENTRYPOINT ["java", "-jar", "/var/lib/nagp-assignment.jar" ]`

4. Using the Dockerfile create the Docker image.
From the directory of Dockerfile - `docker build . -t nagp-assignment`

5. Run the Docker image (nagp-assignment) created in #4.
`docker build . -t nagp-assignment`

## Useful Docker commands
- `docker images`
- `docker container ls`
- `docker logs <container_name>`
- `docker container rm <container_name>`
- `docker image rm <image_name>`
