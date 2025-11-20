# --- FASE 1: La Base ---
# Usamos una imagen oficial de Java 17 (versión JRE - solo para correr)
# Es Alpine, una versión de Linux súper ligera.
FROM eclipse-temurin:17-jre-alpine

# --- FASE 2: Preparación ---
# Establecemos un directorio de trabajo dentro del contenedor.
WORKDIR /app

# Copiamos el .jar (que se crea en la carpeta 'target' cuando ejecutas 'mvn package')
# al directorio /app dentro del contenedor y lo renombramos a 'app.jar'.
# El * se usa para que coincida con cualquier versión (ej. 0.0.1-SNAPSHOT).
COPY target/ms-camiones-*.jar app.jar

# --- FASE 3: Exponer el Puerto ---
# Le informamos a Docker que nuestra app Spring Boot (en application.yml)
# usa el puerto 8081. Esto NO lo publica, solo lo expone internamente.
EXPOSE 8081

# --- FASE 4: El Comando de Arranque ---
# Esta es la instrucción que se ejecuta cuando el contenedor inicia.
# Es lo mismo que escribir "java -jar app.jar" en tu terminal.
ENTRYPOINT ["java", "-jar", "app.jar"]