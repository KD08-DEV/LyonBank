FROM openjdk:17
ADD ./target/docker-spring-boot.war docker-spring-boot.jar
ENTRYPOINT["java","-jar","docker-spring-boot.jar"]