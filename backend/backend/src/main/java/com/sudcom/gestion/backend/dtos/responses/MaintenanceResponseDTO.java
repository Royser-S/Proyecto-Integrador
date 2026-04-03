package com.sudcom.gestion.backend.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceResponseDTO {
    private Long id;
    private Long idEquipo;
    private String nombreEquipo;
    private LocalDate fecha;
    private String descripcion;
    private String tipoMantenimiento;
    private String responsable;
    private String estado;
}
