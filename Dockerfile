FROM eclipse-temurin:21
RUN mkdir /opt/app
COPY ./target/mongo-test-0.1.jar /opt/app/japp.jar
CMD ["java", "-jar", "/opt/app/japp.jar"]