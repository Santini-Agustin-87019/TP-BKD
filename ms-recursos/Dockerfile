# ----- Etapa 1: build con Maven -----
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos pom y descargamos dependencias primero (cachea esto)
COPY pom.xml .
RUN mvn -q -e -B dependency:go-offline

# Ahora copiamos el código fuente y compilamos
COPY src ./src
RUN mvn -q -e -B clean package -DskipTests

# ----- Etapa 2: imagen liviana para correr la app -----
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar generado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Puerto interno de la app 
EXPOSE 8080


ENTRYPOINT ["java","-jar","app.jar"]