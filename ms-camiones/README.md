# ms-camiones – Alta de Camiones (POST `/api/v1/camiones`)

Este documento explica **cómo está organizado el código** y **cómo funciona la lógica** del endpoint de alta de camiones, para que cualquier desarrollador backend pueda entender y extender este microservicio.

---

## 1. Estructura de carpetas relevante

Dentro del proyecto `ms-camiones` (o similar) usamos la siguiente organización:

```txt
src/
 └─ main/
     ├─ java/
     │   └─ com/tpi/backend/mscamiones/
     │       ├─ controller/
     │       │   └─ CamionController.java      # Capa web / API REST
     │       ├─ dto/
     │       │   └─ CamionDto.java             # Objetos para intercambio de datos (request/response)
     │       ├─ model/
     │       │   ├─ Camion.java                # Entidad JPA
     │       │   └─ Transportista.java         # Entidad JPA relacionada
     │       ├─ repository/
     │       │   ├─ CamionRepository.java      # Repositorio JPA para Camion
     │       │   └─ TransportistaRepository.java # Repositorio JPA para Transportista
     │       └─ service/
     │           ├─ CamionService.java         # Interfaz de la lógica de negocio
     │           └─ CamionServiceImpl.java     # Implementación de la lógica de negocio
     └─ resources/
         ├─ application.yml / application.properties  # Configuración de Spring Boot
         └─ (scripts SQL, etc.)
