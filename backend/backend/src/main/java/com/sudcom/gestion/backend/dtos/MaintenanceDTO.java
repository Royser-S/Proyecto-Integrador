package com.sudcom.gestion.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceDTO {
    private Long id;
    private Long equipmentId;
    private String equipmentNombre;
    private LocalDate fecha;
    private String descripcion;
    private String tipo;
    private String responsable;
}
