# -------------------------------------------------------------------
# FASE 1: La Base - ¿Qué necesitamos para correr la app?
# -------------------------------------------------------------------
# Empezamos desde una imagen base que ya tiene Java 17 instalado.
# Usamos "jre" (Java Runtime Environment) porque solo necesitamos *correr* la app, no compilarla.
# "alpine" es una versión de Linux súper ligera.
FROM eclipse-temurin:17-jre-alpine

# -------------------------------------------------------------------
# FASE 2: Preparación - Copiar nuestra app a la "caja"
# -------------------------------------------------------------------
# Establecemos un directorio de trabajo dentro de la "caja"
WORKDIR /app

# Copiamos el .jar (que creamos con 'mvn package') desde nuestra PC (target/...)
# al directorio de trabajo (/app) dentro de la "caja".
# El wildcard (*) evita problemas si la versión cambia (ej. 0.0.2).
COPY target/ms-camiones-*.jar app.jar

# -------------------------------------------------------------------
# FASE 3: Configuración - ¿Qué puertos usamos?
# -------------------------------------------------------------------
# Le informamos a Docker que nuestra app (Spring Boot) usará el puerto 8081.
# Esto es como "abrir el agujero" en la caja para ese puerto.
EXPOSE 8081

# -------------------------------------------------------------------
# FASE 4: El Comando - ¿Cómo se inicia la app?
# -------------------------------------------------------------------
# Esta es la instrucción final que se ejecutará cuando alguien inicie la "caja".
# Es lo mismo que escribir "java -jar app.jar" en la terminal.
ENTRYPOINT ["java", "-jar", "app.jar"]