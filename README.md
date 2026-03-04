# 🚀 Taller Fullstack: Gestión de Colaboradores
### Java 21 + Spring Boot 3 + Angular 20 + Docker

Este proyecto ha sido diseñado como una guía práctica para el taller de la **UTVM**, enfocándose en la construcción de una arquitectura de microservicios moderna, reactiva y orquestada profesionalmente.

---

## 🛠️ Stack Tecnológico

| Componente | Tecnología | Badge | Versión |
| :--- | :--- | :--- | :--- |
| **Backend** | Java (Eclipse Temurin) | ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) | 21 (LTS) |
| **Framework** | Spring Boot | ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) | 3.2.3 |
| **Frontend** | Angular (Standalone) | ![Angular](https://img.shields.io/badge/angular-%23DD0031.svg?style=for-the-badge&logo=angular&logoColor=white) | 20.x |
| **Database** | PostgreSQL | ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white) | 16-alpine |
| **Container** | Docker | ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white) | Latest |
| **Proxy/Web** | Nginx | ![Nginx](https://img.shields.io/badge/nginx-%23009639.svg?style=for-the-badge&logo=nginx&logoColor=white) | Stable |

---

## 📂 Estructura del Proyecto

La organización sigue un patrón modular y escalable para facilitar el mantenimiento y la comprensión del flujo de datos:

```text
.
├── backend/               # Microservicio Java 21 (Spring Boot)
│   └── src/main/java/...  # Lógica sin Lombok para máxima claridad didáctica
├── frontend/              # Aplicación Angular (Arquitectura Standalone)
│   ├── src/app/
│   │   ├── components/    # Vistas de la aplicación (Persona)
│   │   ├── services/      # Lógica de comunicación API
│   │   └── models/        # Interfaces de datos
│   └── nginx.conf         # Configuración del Reverse Proxy
├── postgres_data/         # Volumen persistente de base de datos
└── docker-compose.yml     # Orquestador de infraestructura
```

---

## 📋 Prerrequisitos

Antes de iniciar, asegúrate de tener instalado:
* **Docker & Docker Compose** (Recomendado)
* **Node.js**: v20.x.x (Para desarrollo local)
* **JDK 21**: (Para desarrollo local)

---

## 🚀 Ejecución con Docker

Para levantar todo el ecosistema de forma automatizada:

1. **Construir y levantar:**
   ```bash
   docker-compose up -d --build
   ```
2. **Verificar estado:**
   ```bash
   docker-compose ps
   ```

### 🔗 Puntos de Acceso
* **Frontend:** [http://localhost](http://localhost) (Puerto 80)
* **Documentación API (Swagger):** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 🛠️ Comandos Útiles

* **Ver logs:** `docker-compose logs -f`
* **Actualizar solo el front:** `docker-compose up -d --build frontend`
* **Limpiar todo:** `docker-compose down -v`
