**İçindekiler**

 - JWT
 - Hibernate
 - Mikroservis Mimarisi
 - Docker
 - Docker Compose


**Projeyi Çalıştırmak İçin Ana Dizinde**

    ./gradlew publishToMavenLocal -p core_entity_lib
    ./gradlew publishToMavenLocal -p common
    ./gradlew bootJar -p user_service
    ./gradlew bootJar -p api_gateway 
    ./gradlew bootJar -p command_service 
    ./gradlew bootJar -p category_service 
    ./gradlew bootJar -p discovery_service 
    docker-compose up
 
komutlarını çalıştırmanız yeterli

**Projenin Servisleri (Postman)**
[İndirmek için](https://drive.google.com/open?id=1sRlIdoxga5-uFdAIv_HO9TgbhnfcHMPE)

**Projenin Visualizer Görüntüsü:**
![enter image description here](https://serving.photos.photobox.com/4929971733c43125fc4d6c5d49724c75870d869374024abfab5284430efb47c889239f58.jpg)
