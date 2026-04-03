-- SQL Script to fix duplicate columns created by Hibernate
-- Run this in your MySQL Workbench or CLI

USE gestion_equipos;

-- Fix table 'usuarios'
-- Rename 'password' to 'contrasenia' if necessary, but here they both exist.
-- We will keep 'contrasenia' as the primary one and drop the redundant 'password'.
ALTER TABLE usuarios DROP COLUMN `password`;

-- Fix table 'equipos'
-- Hibernate created 'codigo' and 'nombre', but 'codigo_equipo' and 'nombre_equipo' already exist.
ALTER TABLE equipos DROP COLUMN `codigo`;
ALTER TABLE equipos DROP COLUMN `nombre`;

-- Fix table 'fallas'
-- Hibernate created 'descripcion' and 'estado', but 'descripcion_falla' and 'estado_falla' already exist.
ALTER TABLE fallas DROP COLUMN `descripcion`;
ALTER TABLE fallas DROP COLUMN `estado`;

-- Fix table 'mantenimientos'
-- Hibernate created 'fecha', 'tipo', 'estado', but 'fecha_mantenimiento', 'tipo_mantenimiento' already exist.
-- We need to check which ones the code uses.
-- Based on entities, we'll keep the ones that match our @Column mappings.
ALTER TABLE mantenimientos DROP COLUMN `fecha`;
ALTER TABLE mantenimientos DROP COLUMN `tipo`;

-- Fix table 'reportes'
-- Hibernate created 'tipo', but 'tipo_reporte' already exist.
ALTER TABLE reportes DROP COLUMN `tipo`;

-- Ensure standard column names follow the entities
ALTER TABLE equipos CHANGE COLUMN `nombre_equipo` `nombre` VARCHAR(255) NOT NULL;
ALTER TABLE equipos CHANGE COLUMN `codigo_equipo` `codigo` VARCHAR(255) NOT NULL;

ALTER TABLE fallas CHANGE COLUMN `descripcion_falla` `descripcion` VARCHAR(255) NOT NULL;
ALTER TABLE fallas CHANGE COLUMN `estado_falla` `estado` VARCHAR(255) NOT NULL;

-- After running this, we will update the entities in Java to match these clean names.
