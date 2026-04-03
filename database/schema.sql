-- Database Schema for: Sistema Web de Gestión de Activos, Mantenimiento y Reportes
-- Sprint 1: Base System Fixed Types (INT -> BIGINT)

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
    nombre_equipo VARCHAR(100) NOT NULL,
    codigo_equipo VARCHAR(50) NOT NULL UNIQUE,
    ubicacion VARCHAR(100),
    estado ENUM('OPERATIVO', 'MANTENIMIENTO', 'FUERA_SERVICIO') DEFAULT 'OPERATIVO',
    marca VARCHAR(50),
    modelo VARCHAR(50),
    fecha_adquisicion DATE
);

-- 3. Tabla Mantenimientos
CREATE TABLE IF NOT EXISTS mantenimientos (
    id_mantenimiento BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_equipo BIGINT,
    fecha_mantenimiento DATE NOT NULL,
    descripcion TEXT,
    tipo_mantenimiento ENUM('PREVENTIVO', 'CORRECTIVO') NOT NULL,
    responsable VARCHAR(100),
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE
);

-- 4. Tabla Fallas (Fallas reportadas)
CREATE TABLE IF NOT EXISTS fallas (
    id_falla BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_equipo BIGINT,
    fecha_reporte TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    descripcion_falla TEXT NOT NULL,
    estado_falla ENUM('PENDIENTE', 'EN_REPARACION', 'SOLUCIONADO') DEFAULT 'PENDIENTE',
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo) ON DELETE CASCADE
);

-- 5. Tabla Reportes
CREATE TABLE IF NOT EXISTS reportes (
    id_reporte BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_usuario BIGINT,
    titulo VARCHAR(100) NOT NULL,
    tipo_reporte VARCHAR(50),
    fecha_generacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    contenido TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

-- Datos iniciales
-- Importante: Para el login inicial, usaremos esta contraseña plana y luego la actualizaremos con BCrypt
INSERT INTO usuarios (nombre, usuario, contrasenia, rol) VALUES 
('Administrador', 'admin', 'admin123', 'ADMIN');
