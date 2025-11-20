# Etapa 1: build con Maven y Java 21
FROM maven:3.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos pom y descargamos dependencias (cachea esto)
COPY pom.xml .
RUN mvn -q dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Compilamos y generamos el jar (sin tests)
RUN mvn -q clean package -DskipTests


# Etapa 2: imagen liviana solo con el jar
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos el jar generado desde la etapa de build
COPY --from=build /app/target/ms-operaciones-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto interno del contenedor
EXPOSE 8083

# Comando de arranque
ENTRYPOINT ["java", "-jar", "/app/app.jar"]