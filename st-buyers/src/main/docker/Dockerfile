FROM openjdk
VOLUME /tmp
ADD st-buyers.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/st-buyers.jar"]