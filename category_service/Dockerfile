FROM java:8-jdk-alpine

COPY ./build/libs/category-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app


ENTRYPOINT ["java","-jar","category-0.0.1-SNAPSHOT.jar"]