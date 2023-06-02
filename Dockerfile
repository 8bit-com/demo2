FROM harbor.bft.local/adoptopenjdk/openjdk11:alpine-jre
COPY target/*.jar app.jar
EXPOSE 9999
CMD ["java", "-jar", "app.jar"]
