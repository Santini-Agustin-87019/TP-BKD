# ms-camiones – Microservicio de Gestión de Camiones y Transportistas

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-blue.svg)](https://www.oracle.com/java/)
[![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Latest-blue.svg)](https://www.postgresql.org/)

Este microservicio forma parte de un sistema de gestión de empresa transportista. Permite la administración completa de camiones y transportistas, incluyendo su registro, asignación y control de disponibilidad.

---

## 📋 Tabla de Contenidos

1. [Descripción General](#descripción-general)
2. [Tecnologías Utilizadas](#tecnologías-utilizadas)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Arquitectura y Patrones](#arquitectura-y-patrones)
5. [Modelo de Datos](#modelo-de-datos)
6. [Configuración del Entorno](#configuración-del-entorno)
7. [Endpoints de la API](#endpoints-de-la-api)
8. [Ejecución del Proyecto](#ejecución-del-proyecto)

---

## 📖 Descripción General

**ms-camiones** es un microservicio RESTful desarrollado con Spring Boot que gestiona:

- **Transportistas**: Choferes con sus licencias y datos de identificación
- **Camiones**: Vehículos con sus capacidades, consumos y costos
- **Relaciones**: Asignación de camiones a transportistas

El sistema está diseñado siguiendo principios de arquitectura limpia y separación de responsabilidades.

---

## Tecnologías Utilizadas

### Framework Principal

- **Spring Boot 3.5.7**: Framework principal para desarrollo de aplicaciones Java empresariales
  - `spring-boot-starter-web`: Para crear APIs REST
  - `spring-boot-starter-data-jpa`: Para persistencia de datos con JPA/Hibernate
  - `spring-boot-starter-security`: Para configuración de seguridad
  - `spring-boot-starter-actuator`: Para monitoreo y métricas de la aplicación
  - `spring-boot-devtools`: Herramientas de desarrollo (hot reload)

### Base de Datos

- **PostgreSQL**: Sistema de gestión de base de datos relacional
  - Driver: `org.postgresql:postgresql`
  - Configurado en el puerto `5432`
  - Base de datos: `ms_camiones_db`

### Herramientas de Desarrollo

- **Maven**: Gestor de dependencias y construcción del proyecto
  - Versión del wrapper: incluida en el proyecto (`mvnw`, `mvnw.cmd`)
- **Lombok**: Biblioteca para reducir código boilerplate

  - Genera automáticamente getters, setters, constructores
  - Anotaciones: `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`

- **Java 17**: Versión LTS del lenguaje de programación

### Herramientas Complementarias (Recomendadas)

- **DBeaver**: Cliente de base de datos universal para visualizar y gestionar PostgreSQL
- **Docker** (Opcional): Para contenerización del servicio y base de datos
- **Postman/Thunder Client**: Para pruebas de endpoints REST
- **IntelliJ IDEA/Eclipse**: IDEs recomendados para desarrollo

### Persistencia

- **Hibernate**: Implementación JPA para mapeo objeto-relacional (ORM)
  - Dialecto: `PostgreSQLDialect`
  - Estrategia DDL: `create-drop` (desarrollo)

---

## 📁 Estructura del Proyecto

```
ms-camiones/
│
├── src/
│   ├── main/
│   │   ├── java/com/tpi/backend/mscamiones/
│   │   │   │
│   │   │   ├── MsCamionesApplication.java          # Clase principal (Entry Point)
│   │   │   │
│   │   │   ├── config/                             # Configuración de la aplicación
│   │   │   │   └── SecurityConfig.java             # Configuración de seguridad Spring Security
│   │   │   │
│   │   │   ├── controller/                         # Capa de Controladores (API REST)
│   │   │   │   ├── CamionController.java           # Endpoints de Camiones
│   │   │   │   └── TransportistaController.java    # Endpoints de Transportistas
│   │   │   │
│   │   │   ├── dto/                                # Data Transfer Objects
│   │   │   │   ├── CamionDto.java                  # DTO para request/response de Camión
│   │   │   │   └── TransportistaDto.java           # DTO para request/response de Transportista
│   │   │   │
│   │   │   ├── model/                              # Entidades JPA (Modelo de Dominio)
│   │   │   │   ├── Camion.java                     # Entidad Camión
│   │   │   │   └── Transportista.java              # Entidad Transportista
│   │   │   │
│   │   │   ├── repository/                         # Capa de Persistencia (Repositorios JPA)
│   │   │   │   ├── CamionRepository.java           # Repositorio de Camiones
│   │   │   │   └── TransportistaRepository.java    # Repositorio de Transportistas
│   │   │   │
│   │   │   └── service/                            # Capa de Lógica de Negocio (Servicios)
│   │   │       ├── CamionService.java              # Interfaz del servicio de Camiones
│   │   │       ├── CamionServiceImpl.java          # Implementación del servicio de Camiones
│   │   │       ├── TransportistaService.java       # Interfaz del servicio de Transportistas
│   │   │       └── TransportistaServiceImpl.java   # Implementación del servicio de Transportistas
│   │   │
│   │   └── resources/
│   │       ├── application.yaml                    # Configuración de Spring Boot
│   │       ├── static/                             # Recursos estáticos (vacío)
│   │       └── templates/                          # Plantillas (vacío)
│   │
│   └── test/                                       # Tests unitarios y de integración
│       └── java/com/tpi/backend/mscamiones/
│           └── MsCamionesApplicationTests.java     # Test de contexto de Spring
│
├── target/                                         # Archivos compilados (generado por Maven)
├── pom.xml                                         # Descriptor de dependencias Maven
├── mvnw                                            # Maven Wrapper para Unix/Linux
├── mvnw.cmd                                        # Maven Wrapper para Windows
├── HELP.md                                         # Ayuda de Spring Boot
└── README.md                                       # Este archivo
```

### 📂 Descripción de Carpetas Principales

#### **`config/`** - Configuración

Contiene clases de configuración de Spring:

- **`SecurityConfig.java`**: Configura Spring Security para permitir todas las peticiones en desarrollo y deshabilitar CSRF para facilitar pruebas con herramientas como Postman.

#### **`controller/`** - Controladores REST

Capa de presentación que expone los endpoints HTTP:

- **`CamionController.java`**: Maneja las peticiones HTTP relacionadas con camiones (`POST /api/v1/camiones`)
- **`TransportistaController.java`**: Maneja las peticiones HTTP relacionadas con transportistas (`POST /api/v1/transportistas`)

#### **`dto/`** - Data Transfer Objects

Objetos simples para transferencia de datos entre cliente y servidor:

- **`CamionDto.java`**: Estructura de datos para crear/recibir información de camiones
- **`TransportistaDto.java`**: Estructura de datos para crear/recibir información de transportistas

Los DTOs no contienen lógica de negocio y sirven para desacoplar la API de las entidades de base de datos.

#### **`model/`** - Entidades JPA

Clases que representan las tablas de la base de datos:

- **`Camion.java`**: Entidad que mapea la tabla `camiones`

  - Primary Key: `dominio` (String - patente del camión)
  - Campos: capacidad de peso, volumen, consumo, costo base
  - Relación: `@ManyToOne` con Transportista

- **`Transportista.java`**: Entidad que mapea la tabla `transportistas`
  - Primary Key: `id` (Long - autoincremental)
  - Campos: licencia, fecha de vencimiento, ID de usuario Keycloak
  - Relación: `@OneToMany` con Camiones (implícita)

#### **`repository/`** - Repositorios JPA

Interfaces que extienden `JpaRepository` para operaciones de base de datos:

- **`CamionRepository.java`**: Repositorio para operaciones CRUD de Camión
  - Tipo de entidad: `Camion`
  - Tipo de PK: `String`
- **`TransportistaRepository.java`**: Repositorio para operaciones CRUD de Transportista
  - Tipo de entidad: `Transportista`
  - Tipo de PK: `Long`

Spring Data JPA genera automáticamente la implementación con métodos como `save()`, `findById()`, `findAll()`, etc.

#### **`service/`** - Servicios (Lógica de Negocio)

Capa que contiene la lógica de negocio de la aplicación:

**Interfaces:**

- **`CamionService.java`**: Define el contrato para operaciones de negocio de camiones
- **`TransportistaService.java`**: Define el contrato para operaciones de negocio de transportistas

**Implementaciones:**

- **`CamionServiceImpl.java`**:

  - Implementa la lógica de creación de camiones
  - Valida la existencia del transportista
  - Establece disponibilidad inicial del camión
  - Mapea DTOs a entidades

- **`TransportistaServiceImpl.java`**:
  - Implementa la lógica de creación de transportistas
  - Mapea DTOs a entidades
  - Persiste en base de datos

---

## 🏗️ Arquitectura y Patrones

El proyecto sigue una **arquitectura en capas (Layered Architecture)** con separación clara de responsabilidades:

```
┌─────────────────────────────────────────┐
│         CLIENTE (Postman, App)          │
└──────────────────┬──────────────────────┘
                   │ HTTP Request
                   ▼
┌─────────────────────────────────────────┐
│   CONTROLLER (Capa de Presentación)     │  ← Recibe peticiones HTTP
│   - CamionController                    │  ← Valida entrada básica
│   - TransportistaController             │  ← Retorna respuestas HTTP
└──────────────────┬──────────────────────┘
                   │ DTO
                   ▼
┌─────────────────────────────────────────┐
│   SERVICE (Capa de Negocio)             │  ← Lógica de negocio
│   - CamionServiceImpl                   │  ← Validaciones complejas
│   - TransportistaServiceImpl            │  ← Orquestación de operaciones
└──────────────────┬──────────────────────┘
                   │ Entidades
                   ▼
┌─────────────────────────────────────────┐
│   REPOSITORY (Capa de Persistencia)     │  ← Acceso a datos
│   - CamionRepository                    │  ← Operaciones CRUD
│   - TransportistaRepository             │  ← Consultas SQL generadas
└──────────────────┬──────────────────────┘
                   │ SQL
                   ▼
┌─────────────────────────────────────────┐
│        BASE DE DATOS (PostgreSQL)       │
└─────────────────────────────────────────┘
```

### Patrones de Diseño Implementados

1. **Repository Pattern**: Abstracción de la capa de persistencia
2. **Service Layer Pattern**: Encapsulación de la lógica de negocio
3. **DTO Pattern**: Separación entre modelo de dominio y API
4. **Dependency Injection**: Inyección de dependencias con Spring
5. **Interface Segregation**: Interfaces separadas para cada servicio

---

## 💾 Modelo de Datos

### Diagrama Entidad-Relación

```
┌──────────────────────┐           ┌─────────────────────────┐
│   TRANSPORTISTA      │           │       CAMION            │
├──────────────────────┤           ├─────────────────────────┤
│ id (PK)              │◄──────────┤ dominio (PK)            │
│ licencia             │    1:N    │ id_transportista (FK)   │
│ fecha_venc_licencia  │           │ capacidad_peso_kg       │
│ id_usuario_keycloak  │           │ capacidad_volumen_m3    │
└──────────────────────┘           │ consumo_combustible_km  │
                                   │ costo_base_km           │
                                   │ disponible              │
                                   └─────────────────────────┘
```

### Descripción de Entidades

#### **Transportista**

| Campo                        | Tipo              | Descripción                         |
| ---------------------------- | ----------------- | ----------------------------------- |
| `id`                         | BIGINT (PK, Auto) | Identificador único                 |
| `licencia`                   | VARCHAR           | Número de licencia de conducir      |
| `fecha_vencimiento_licencia` | DATE              | Fecha de vencimiento de la licencia |
| `id_usuario_keycloak`        | VARCHAR (UNIQUE)  | ID del usuario en Keycloak          |

#### **Camión**

| Campo                    | Tipo         | Descripción                                    |
| ------------------------ | ------------ | ---------------------------------------------- |
| `dominio`                | VARCHAR (PK) | Patente del camión                             |
| `id_transportista`       | BIGINT (FK)  | Referencia al transportista asignado           |
| `capacidad_peso_kg`      | DOUBLE       | Capacidad máxima de carga en kilogramos        |
| `capacidad_volumen_m3`   | DOUBLE       | Capacidad máxima de carga en metros cúbicos    |
| `consumo_combustible_km` | DOUBLE       | Consumo de combustible en litros por kilómetro |
| `costo_base_km`          | DOUBLE       | Costo base por kilómetro recorrido             |
| `disponible`             | BOOLEAN      | Indica si el camión está disponible            |

---

## ⚙️ Configuración del Entorno

### Prerrequisitos

1. **Java 17** o superior
2. **Maven 3.6+** (o usar el wrapper incluido)
3. **PostgreSQL** instalado y en ejecución
4. **DBeaver** (opcional, para administración de BD)

### Configuración de PostgreSQL

1. **Crear la base de datos:**

```sql
CREATE DATABASE ms_camiones_db;
```

2. **Crear usuario (opcional):**

```sql
CREATE USER camiones_user WITH PASSWORD 'tu_password';
GRANT ALL PRIVILEGES ON DATABASE ms_camiones_db TO camiones_user;
```

### Configuración de `application.yaml`

El archivo se encuentra en `src/main/resources/application.yaml`:

```yaml
server:
  port: 8081 # Puerto del microservicio

spring:
  application:
    name: ms-camiones # Nombre de la aplicación

  datasource:
    url: jdbc:postgresql://localhost:5432/ms_camiones_db?serverTimezone=UTC
    username: postgres # ⚠️ Cambiar según tu configuración
    password: admin # ⚠️ Cambiar según tu configuración
    driver-class-name: org.postgresql.Driver

  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: create-drop # ⚠️ En producción usar 'validate' o 'none'
    show-sql: true # Muestra las queries SQL en consola
    properties:
      hibernate:
        format_sql: true # Formatea el SQL para mejor legibilidad
        jdbc:
          time_zone: UTC # Zona horaria UTC
```

**⚠️ Importante:**

- En **desarrollo**: `ddl-auto: create-drop` (crea y borra tablas al reiniciar)
- En **producción**: `ddl-auto: validate` o usar migraciones con Flyway/Liquibase

---

## 🌐 Endpoints de la API

### Base URL

```
http://localhost:8081/api/v1
```

### Transportistas

#### Crear Transportista

```http
POST /api/v1/transportistas
Content-Type: application/json

{
  "licencia": "B123456",
  "fechaVencimientoLicencia": "2025-12-31",
  "idUsuarioKeycloak": "user-uuid-123"
}
```

**Respuesta exitosa (200 OK):**

```json
{
  "id": 1,
  "licencia": "B123456",
  "fechaVencimientoLicencia": "2025-12-31",
  "idUsuarioKeycloak": "user-uuid-123"
}
```

### Camiones

#### Crear Camión

```http
POST /api/v1/camiones
Content-Type: application/json

{
  "dominio": "ABC123",
  "capPesoKg": 5000.0,
  "capVolumenM3": 30.0,
  "consumoKm": 0.15,
  "costoBaseKm": 50.0,
  "transportistaId": 1
}
```

**Respuesta exitosa (200 OK):**

```json
{
  "dominio": "ABC123",
  "capacidadPeso": 5000.0,
  "capacidadVolumen": 30.0,
  "consumo": 0.15,
  "costoBaseKm": 50.0,
  "disponibilidad": true,
  "transportista": {
    "id": 1,
    "licencia": "B123456",
    "fechaVencimientoLicencia": "2025-12-31",
    "idUsuarioKeycloak": "user-uuid-123"
  }
}
```

**Respuesta de error (404 Not Found):**

```json
{
  "timestamp": "2025-11-13T10:30:00.000+00:00",
  "status": 404,
  "error": "Not Found",
  "message": "No se encontró el transportista con ID: 999",
  "path": "/api/v1/camiones"
}
```

---

## 🚀 Ejecución del Proyecto

### Opción 1: Con Maven Wrapper (Recomendado)

**Windows:**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux/Mac:**

```bash
./mvnw spring-boot:run
```

### Opción 2: Con Maven instalado

```bash
mvn spring-boot:run
```

### Opción 3: Compilar y ejecutar JAR

```bash
# Compilar
./mvnw clean package

# Ejecutar
java -jar target/ms-camiones-0.0.1-SNAPSHOT.jar
```

### Verificar que el servicio está corriendo

```bash
curl http://localhost:8081/actuator/health
```

Debería responder:

```json
{ "status": "UP" }
```

---

## 🧪 Pruebas con Postman

1. **Crear un Transportista primero:**

   - Método: POST
   - URL: `http://localhost:8081/api/v1/transportistas`
   - Body (JSON):

   ```json
   {
     "licencia": "B123456",
     "fechaVencimientoLicencia": "2025-12-31",
     "idUsuarioKeycloak": "user-uuid-123"
   }
   ```

2. **Crear un Camión:**
   - Método: POST
   - URL: `http://localhost:8081/api/v1/camiones`
   - Body (JSON):
   ```json
   {
     "dominio": "ABC123",
     "capPesoKg": 5000.0,
     "capVolumenM3": 30.0,
     "consumoKm": 0.15,
     "costoBaseKm": 50.0,
     "transportistaId": 1
   }
   ```

---

## 📊 Verificar Datos en DBeaver

1. Conectar a PostgreSQL:

   - Host: `localhost`
   - Port: `5432`
   - Database: `ms_camiones_db`
   - Usuario: `postgres`
   - Password: `admin`

2. Ejecutar queries:

```sql
-- Ver todos los transportistas
SELECT * FROM transportistas;

-- Ver todos los camiones con su transportista
SELECT
    c.dominio,
    c.capacidad_peso_kg,
    c.disponible,
    t.licencia AS transportista_licencia
FROM camiones c
LEFT JOIN transportistas t ON c.id_transportista = t.id;
```

---

## 🔧 Tecnologías en Detalle

### Spring Boot

Framework que simplifica el desarrollo de aplicaciones Java mediante:

- Configuración automática
- Servidor embebido (Tomcat)
- Gestión de dependencias
- Métricas y monitoreo (Actuator)

### PostgreSQL

Base de datos relacional elegida por:

- Robustez y confiabilidad
- Soporte completo de ACID
- Excelente rendimiento
- Open source

### Hibernate/JPA

ORM que permite:

- Mapear objetos Java a tablas SQL
- Generar automáticamente esquemas de BD
- Realizar consultas con JPQL
- Gestión automática de relaciones

### Lombok

Reduce código repetitivo generando automáticamente:

- Getters y setters
- Constructores
- Métodos `toString()`, `equals()`, `hashCode()`

### Maven

Gestor de dependencias que:

- Descarga librerías automáticamente
- Compila el proyecto
- Ejecuta tests
- Genera artefactos (JAR/WAR)

---

## 📝 Notas Importantes

- **Seguridad**: Actualmente configurada para desarrollo (sin autenticación). En producción se debe integrar con Keycloak u otro proveedor OAuth2.
- **Validaciones**: Se recomienda agregar validaciones con `@Valid` y Bean Validation en los DTOs.
- **Manejo de Errores**: Implementar un `@ControllerAdvice` para manejo centralizado de excepciones.
- **Logging**: Configurar niveles de log apropiados para producción.
- **Documentación API**: Se recomienda integrar Swagger/OpenAPI para documentación interactiva.

---

## 👥 Autor

Proyecto desarrollado para el curso de Backend - Empresa Transportista

---

## 📄 Licencia

Este proyecto es parte de un trabajo académico.
