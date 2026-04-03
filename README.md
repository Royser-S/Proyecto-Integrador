# 🛡️ SUDCOM - Sistema de Gestión de Activos Pro

SUDCOM es una plataforma empresarial diseñada para centralizar el control de activos tecnológicos, automatizar el seguimiento de mantenimientos y gestionar incidencias mediante un diseño premium e intuitivo.

---

## 📂 Estructura del Proyecto

### 🏗️ Backend (Spring Boot 3.4.3)
Ubicación: `/backend/backend/src/main/java/com/sudcom/gestion/backend/`

| Carpeta | Descripción |
| :--- | :--- |
| `controllers/` | Definición de los Endpoints REST API (Equipos, Mantenimientos, Auth, etc.). |
| `entities/` | Modelos de datos de JPA (Mapeo directo con las tablas de MySQL). |
| `repositories/` | Interfaces de Spring Data JPA para el acceso a la base de datos. |
| `services/` | Lógica de negocio (Contratos de interfaces). |
| `services/impl/` | Implementación real de la lógica de negocio. |
| `dtos/` | Objetos de transferencia de datos para peticiones y respuestas limpias. |
| `security/` | Configuración de Spring Security, filtros JWT y utilitarios de cifrado. |
| `config/` | Configuraciones globales del sistema (CORS, Jackson, etc.). |

### 🎨 Frontend (Angular 21)
Ubicación: `/frontend/src/app/`

| Carpeta | Descripción |
| :--- | :--- |
| `components/layout/` | Componentes estructurales como el Sidebar, Navbar y el Layout principal. |
| `pages/dashboard/` | Panel principal con visualización de métricas y estados. |
| `pages/equipment-*/` | Listado y formularios para la gestión de equipos (CRUD). |
| `pages/maintenance-*/` | Control detallado y programación de servicios técnicos. |
| `pages/reports/` | Módulo dinámico para la visualización de historial de reportes. |
| `services/` | Lógica de comunicación HTTP con la API Backend (Inyectables). |
| `assets/` | Imágenes, iconos y recursos estáticos del sistema. |

---

## 🛠️ Requisitos del Sistema
- **Java**: 21 (LTS)
- **Node.js**: 18+ (Recomendado v20+)
- **MySQL**: 8.0+
- **Angular CLI**: 19+

---

## 🚀 Guía de Instalación Detallada

### 1. Configuración de Base de Datos
1. Crea el schema en tu servidor MySQL: `CREATE DATABASE gestion_equipos;`
2. Ejecuta el archivo inicial: [`backend/backend/src/main/resources/data.sql`](file:///c:/Users/VelozNET-Central/OneDrive%20-%20CIBERTEC/Documentos/PROGRAMACION/Proyecto-6cto-ciclo/Proyecto-integrador/backend/backend/src/main/resources/data.sql).
   - *Nota: Este archivo crea las tablas e inserta los usuarios `admin` y `juan.tecnico`.*

### 2. Puesta en Marcha del Backend
1. Abre la carpeta `backend/backend` en tu IDE (IntelliJ recomendado).
2. Edita [`src/main/resources/application.yaml`](file:///c:/Users/VelozNET-Central/OneDrive%20-%20CIBERTEC/Documentos/PROGRAMACION/Proyecto-6cto-ciclo/Proyecto-integrador/backend/backend/src/main/resources/application.yaml):
   ```yaml
   spring:
     datasource:
       url: jdbc:mysql://localhost:3306/gestion_equipos
       username: TU_USUARIO
       password: TU_CONTRASEÑA
   ```
3. Ejecuta la aplicación: `./mvnw spring-boot:run`

### 3. Puesta en Marcha del Frontend
1. Entra a la carpeta `frontend/`.
2. Instala dependencias: `npm install`
3. Ejecuta el servidor: `ng serve`
4. Accede a `http://localhost:4200`

---

## 🛡️ Seguridad y Roles
El sistema implementa seguridad basada en **JWT (JSON Web Tokens)**:
- **Técnico**: Puede gestionar equipos y reportar fallas.
- **Administrador**: Acceso total a reportes, gestión de usuarios y configuraciones globales.

---

## 📝 Flujos de Trabajo Actuales
- **Inventario**: Registro de marca, modelo, código único y ubicación física.
- **Mantenimiento**: Programación de fechas con estados (PENDIENTE, EN PROCESO, COMPLETADO).
- **Reportes**: Registro dinámico de actividad técnica exportable visualmente.

---

> [!TIP]
> Si añades nuevos iconos, recuerda registrarlos en `app.config.ts` dentro de `LucideIconProvider`.
