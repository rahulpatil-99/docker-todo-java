FROM openjdk:8-jre-alpine

WORKDIR /var/todoapp

COPY /build/libs/todoapp.jar .

EXPOSE 8080

CMD ["java", "-jar", "./todoapp.jar"]