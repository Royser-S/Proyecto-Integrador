package com.sudcom.gestion.backend.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MaintenanceRequestDTO {
    private Long id;
    private Long idEquipo;
    private LocalDate fecha;
    private String descripcion;
    private String responsable;
    private String tipoMantenimiento;
    private String estado;
}
