FROM java:8-jdk-alpine

COPY ./build/libs/command-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch command-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","command-0.0.1-SNAPSHOT.jar"]