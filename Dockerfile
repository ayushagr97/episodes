FROM openjdk:17
EXPOSE 8082
ADD target/dockerepisdoe.jar dockerepisdoe.jar
ENTRYPOINT ["java","-jar","/dockerepisdoe.jar"]