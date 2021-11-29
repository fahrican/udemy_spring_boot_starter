# define base docker image
FROM openjdk:11
LABEL maintainer="onecosys.com"
ADD target/udemy_spring_boot_starter-0.0.1-SNAPSHOT.jar spring_boot_docker.jar
ENTRYPOINT ["java", "-jar", "spring_boot_docker.jar"]