package com.sudcom.gestion.backend.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailureResponseDTO {
    private Long id;
    private Long idEquipo;
    private String nombreEquipo;
    private LocalDateTime fechaReporte;
    private String descripcion;
    private String estado;
}
