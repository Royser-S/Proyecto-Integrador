-- Insert sample users (password is 'password' BCrypt hashed $2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqCYAdVqCcL7HWXCuaaupc6X/Eya)
INSERT INTO usuarios (nombre, usuario, contrasenia, rol, fecha_registro) VALUES 
('Tecnico Juan', 'juan.tecnico', '$2a$10$8.UnVuG9HHgffUDAlk8qfOuVGkqCYAdVqCcL7HWXCuaaupc6X/Eya', 'TECNICO', NOW());

-- Insert sample equipment
INSERT INTO equipos (nombre, codigo, marca, modelo, fecha_adquisicion, ubicacion, estado) VALUES 
('Laptop Dell Latitude', 'EQU-001', 'Dell', 'Latitude 5420', '2023-01-15', 'Oficina 101', 'ACTIVO'),
('Impresora HP LaserJet', 'EQU-002', 'HP', 'LaserJet Pro', '2022-11-20', 'Secretaría', 'MANTENIMIENTO'),
('Servidor Dell PowerEdge', 'EQU-003', 'Dell', 'T440', '2023-05-10', 'Data Center', 'ACTIVO'),
('Proyector Epson', 'EQU-004', 'Epson', 'PowerLite', '2023-02-15', 'Sala de Reuniones', 'DEBAJA');

-- Insert sample failures
INSERT INTO fallas (id_equipo, id_usuario, descripcion, fecha_reporte, estado) VALUES 
(1, 1, 'La pantalla parpadea ocasionalmente', NOW(), 'REPORTADA'),
(2, 2, 'Papel atascado en el fusor', NOW(), 'EN_REPARACION');

-- Insert sample maintenances
INSERT INTO mantenimientos (id_equipo, fecha_mantenimiento, responsable, tipo_mantenimiento, descripcion, estado) VALUES 
(1, '2023-12-01', 'Juan Tecnico', 'PREVENTIVO', 'Limpieza interna y cambio de pasta térmica', 'COMPLETADO'),
(3, '2024-01-10', 'Carlos Admin', 'CORRECTIVO', 'Cambio de disco duro por falla de sectores', 'PENDIENTE');

-- Insert sample reports
INSERT INTO reportes (titulo, contenido, tipo_reporte, fecha_generacion, id_usuario) VALUES 
('Reporte Mensual de Equipos', 'Resumen de estado de equipos para el mes de Marzo...', 'EQUIPOS', '2024-03-31', 1),
('Auditoría de Mantenimientos Q1', 'Detalle de mantenimientos realizados en el primer trimestre...', 'MANTENIMIENTO', '2024-04-01', 1);
