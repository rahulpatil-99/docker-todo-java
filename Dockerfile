FROM openjdk:latest

WORKDIR /var/todoApp

COPY . .

EXPOSE 8080

CMD ["./gradlew", "clean", "build", "bootrun"]