# API para la Gestión de franjas horarias FIET 
![Static Badge](https://img.shields.io/badge/Spring%20Boot-3.3.5-1b1f23?style=for-the-badge&logo=spring%20boot&logoColor=white&labelColor=6cb52d) ![Static Badge](https://img.shields.io/badge/JDK-17-1b1f23?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=orange) ![Static Badge](https://img.shields.io/badge/MySQL-4d7ca0?style=for-the-badge&logo=mysql&logoColor=white) 

Proyecto para el curso de Arquitectura de Software para Aplicaciones Empresariales que consiste de un backend en Spring Boot, empleando Arquitectura Hexagonal o de Puertos y Adaptadores, con el propósito de permitir realizar una gestión de franjas horarias.


## Principales Funcionalidades ⭐

* Gestión de docentes y personal administrativo
* Administración de espacios físicos
* Control de franjas horarias
* Asignación de cursos y asignaturas
* Validaciones automáticas de disponibilidad

## Tecnologías Utilizadas 🛠️
* JDK 17
* Spring Boot 3.3.5
* Hibernate JPA
* Base de datos MySQL
* Maven

## Estructura de la carpeta src 📁

```
src
├── main
│   ├── java
│   │   └── com.unicauca.fiet
│   │       ├── application
│   │       │   ├── input
│   │       │   └── output
│   │       ├── domain
│   │       │   ├── models
│   │       │   └── usecase
│   │       └── infrastructure
│   │           ├── configuration
│   │           ├── input
│   │           │   ├── controller
│   │           │   ├── dto
│   │           │   └── mapper
│   │           └── output
│   │               ├── persistence
│   │               │   ├── entity
│   │               │   ├── repository
│   │               │   └── mapper
│   │               └── exceptions
│   └── resources
│       ├── application.properties
│       └── messages.properties
```

## Requisitos Previos 📋

* Java JDK 17 o superior
* MySQL
* Postman/Thunder Client para pruebas

## Adicional 🔧

Configurar la base de datos en `application.properties`:
```properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost/bd_nombre?useSSL=false&serverTimezone=GMT&allowPublicKeyRetrieval=true
spring.datasource.username=tu_usuario
spring.datasource.password=tu_contraseña
```

## Validaciones Implementadas ✅

### Validaciones Automáticas
* Campos requeridos en docentes, espacios físicos y franjas horarias
* Formato de correo electrónico
* Tamaños mínimos y máximos en campos
* Parámetros de URL

### Reglas de Negocio
* Validación de disponibilidad de espacio físico
* Validación de disponibilidad de docente
* Unicidad de correo electrónico de docente

## Ejemplos de Uso 📝

### Crear Docente
Endpoint: `POST /api/docentes`

```json
{
  "nombres": "Juan",
  "apellidos": "Pérez",
  "correo": "jperez@unicauca.edu.co",
  "oficina": {
    "nombre": "OF-201",
    "ubicacion": "Edificio FIET"
  }
}
```

### Crear Franja Horaria
Endpoint: `POST /api/franjas`

```json
{
  "dia": "LUNES",
  "horaInicio": "07:00",
  "horaFin": "09:00",
  "cursoId": 1,
  "espacioFisicoId": 2
}
```
