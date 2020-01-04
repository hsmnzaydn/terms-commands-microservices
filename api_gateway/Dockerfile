FROM java:8-jdk-alpine

COPY ./build/libs/api_gateway-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app


ENTRYPOINT ["java","-jar","api_gateway-0.0.1-SNAPSHOT.jar"]