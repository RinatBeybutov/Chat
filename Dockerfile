FROM maven:3.8.4-openjdk-17

WORKDIR /app
COPY ./app.jar ./app.jar

EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]