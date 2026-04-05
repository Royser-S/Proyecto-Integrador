-- Database Schema for: Sistema Web de Gestión de Activos, Mantenimiento y Reportes
-- Actualizado según Entidades JPA (Spring Boot)

CREATE DATABASE IF NOT EXISTS gestion_equipos;
USE gestion_equipos;

-- 1. Tabla Usuarios
CREATE TABLE IF NOT EXISTS usuarios (
    id_usuario BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) NOT NULL UNIQUE,
    contrasenia VARCHAR(255) NOT NULL,
    rol VARCHAR(20) NOT NULL DEFAULT 'USER',
    fecha_registro TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 2. Tabla Equipos
CREATE TABLE IF NOT EXISTS equipos (
    id_equipo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    marca VARCHAR(50),
    modelo VARCHAR(50),
    fecha_adquisicion DATE,
    ubicacion VARCHAR(100),
    estado VARCHAR(50) DEFAULT 'ACTIVO'
);

-- 3. Tabla Mantenimientos
CREATE TABLE IF NOT EXISTS mantenimientos (
    id_mantenimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_equipo BIGINT NOT NULL,
    fecha_mantenimiento DATE NOT NULL,
    responsable VARCHAR(100),
    tipo_mantenimiento VARCHAR(50) NOT NULL,
    descripcion TEXT,
    estado VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE
);

-- 4. Tabla Fallas (Reportadas)
CREATE TABLE IF NOT EXISTS fallas (
    id_falla BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_equipo BIGINT NOT NULL,
    id_usuario BIGINT NOT NULL,
    descripcion TEXT NOT NULL,
    fecha_reporte TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    estado VARCHAR(50) DEFAULT 'REPORTADA',
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- 5. Tabla Reportes
CREATE TABLE IF NOT EXISTS reportes (
    id_reporte BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_usuario BIGINT NOT NULL,
    titulo VARCHAR(100) NOT NULL,
    contenido TEXT,
    tipo_reporte VARCHAR(50),
    fecha_generacion DATE NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Datos iniciales de prueba (Contraseña: password)
INSERT INTO usuarios (nombre, usuario, contrasenia, rol) VALUES 
('Admin User', 'admin', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqCYAdVqCcL7HWXCuaaupc6X/Eya', 'ADMIN'),
('Tecnico Juan', 'juan.tecnico', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqCYAdVqCcL7HWXCuaaupc6X/Eya', 'TECNICO');
