# Usa una imagen base con Maven para compilar el proyecto
# As Build define una etapa de construcción 
FROM maven:3.9.8-eclipse-temurin-17 AS build

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos necesarios para compilar el proyecto
# copiar pom.xml para que Maven descargue las dependencias primero
COPY pom.xml .
# copiar el código fuente
COPY src ./src
# Compilar el proyecto y empaquetarlo dentro de la etapa build, omitiendo los tests
RUN mvn -q -DskipTests package

# Etapa 2: Ejecutar el jar
# Usar una imagen base más liviana para ejecutar la aplicación
FROM eclipse-temurin:17-jre
# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app
# usar wildcard por si cambia el nombre/versión del jar

# Copiar el archivo jar compilado desde la etapa build y lo renombra a app.jar
# --from=build toma archivos de la etapa previa.
COPY --from=build /app/target/*.jar app.jar
# Exponer el puerto 8090 para el API Gateway
EXPOSE 8090
# Comando para ejecutar la aplicación Java
ENTRYPOINT ["java","-jar","/app/app.jar"]