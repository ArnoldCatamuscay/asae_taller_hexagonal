
![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)


# API para la Gestión de franjas horarias FIET 

Proyecto para el curso de Arquitectura de Software para Aplicaciones Empresariales que consiste de un backend en Spring Boot, empleando Arquitectura Hexagonal o de Puertos y Adaptadores, con el propósito de permitir realizar una gestión de franjas horarias.


## Principales Funcionalidades ⭐

* Gestión de docentes y personal administrativo
* Administración de espacios físicos
* Control de franjas horarias
* Asignación de cursos y asignaturas
* Validaciones automáticas de disponibilidad

## Tecnologías Utilizadas 🛠️
* Java 17
* Spring Boot 3.x
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
spring.datasource.url=jdbc:postgresql://localhost:5432/fiet_horarios
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
```json
POST /api/docentes
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
```json
POST /api/franjas
{
  "dia": "LUNES",
  "horaInicio": "07:00",
  "horaFin": "09:00",
  "cursoId": 1,
  "espacioFisicoId": 2
}
```
