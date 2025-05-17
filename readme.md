# 📚 API Educativa

API REST desarrollada con Spring Boot para la gestión de cursos, estudiantes y profesores.

---

## 📦 Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.5
- Spring Data JPA
- MySQL
- Springdoc OpenAPI (Swagger)
- Lombok

---

## 🚀 Cómo ejecutar el proyecto

### Requisitos:

- JDK 17
- Maven
- MySQL (Puerto 3306, Base de Datos: `bd_educativa`)
## 📖 Documentación Swagger

Una vez que la aplicación esté corriendo, puedes acceder a la documentación interactiva de la API a través de Swagger UI:

👉 [http://localhost:8082/swagger-ui/index.html](http://localhost:8082/swagger-ui/index.html)

También puedes obtener el esquema JSON de la API siguiendo este enlace:

👉 [http://localhost:8082/v3/api-docs](http://localhost:8082/v3/api-docs)

---

## 🛠️ Endpoints disponibles

A continuación, se detallan los endpoints disponibles en la API:

| Método | Endpoint           | Descripción                  |
|--------|--------------------|------------------------------|
| GET    | `/api/cursos`      | Listar todos los cursos      |
| GET    | `/api/cursos/{id}` | Obtener curso por ID         |
| POST   | `/api/cursos`      | Crear un nuevo curso         |
| PUT    | `/api/cursos/{id}` | Actualizar curso existente   |
| DELETE | `/api/cursos/{id}` | Eliminar curso por ID        |
