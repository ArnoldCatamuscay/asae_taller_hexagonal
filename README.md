# API para la Gestión de franjas horarias FIET 
![Static Badge](https://img.shields.io/badge/Spring%20Boot-3.3.5-1b1f23?style=for-the-badge&logo=spring%20boot&logoColor=white&labelColor=6cb52d) ![Static Badge](https://img.shields.io/badge/JDK-17-1b1f23?style=for-the-badge&logo=openjdk&logoColor=white&labelColor=orange) ![Static Badge](https://img.shields.io/badge/MySQL-4d7ca0?style=for-the-badge&logo=mysql&logoColor=white) 

Proyecto para el curso de Arquitectura de Software para Aplicaciones Empresariales que consiste de un backend en Spring Boot, empleando Arquitectura Hexagonal o de Puertos y Adaptadores, con el propósito de permitir realizar una gestión de franjas horarias.

## Flujo simplificado de ejecución
![Flujo de ejecución](https://github.com/user-attachments/assets/d9886481-b3b3-420a-bc42-b46c968e2488)

## Principales Funcionalidades ⭐

* Registro de franjas horarias
* Registro de docentes
* Listado de las franajas horarias de un docente
* Listado de espacios físicos

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
* Validación de disponibilidad de espacio físico al registrar franja horaria
* Validación de disponibilidad de docente al registrar franja horaria

## Ejemplos de Uso 📝

### Crear Docente
Endpoint: `POST localhost:5000/api/docentes/`

```json
{
  "nombre": "Juan",
  "apellido": "Gonzales",
  "correo": "juang@unicauca.edu.co",
  "oficina":{
      "nombre": "Oficina 402",
      "ubicacion": "FIET"
  }
}
```

### Crear Franja Horaria
Endpoint: `POST localhost:5000/api/franjas-horarias/`

```json
{
  "dia": "Martes",
  "horaInicio": "09:00",
  "horaFin": "11:00",
  "idCurso": 1,
  "idEspacioFisico": 1
}
```

### Listar Franjas Horarias por Docente
Endpoint: `GET localhost:5000/api/franjas-horarias/listarPorDocente/1`

### Listar Espacios físicos
Endpoint: `GET localhost:5000/api/espacios-fisicos/?patron=sa&capacidad=25`
