FROM java:8-jdk-alpine

COPY ./build/libs/user_service-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app


ENTRYPOINT ["java","-jar","user_service-0.0.1-SNAPSHOT.jar"]