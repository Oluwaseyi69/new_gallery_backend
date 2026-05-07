FROM eclipse-temurin:17-jdk AS build
COPY . .
RUN mvn clean install -DskipTests

FROM eclipse-temurin:17-jre
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java", "-jar",  "app.jar"]