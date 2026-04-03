package com.sudcom.gestion.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FailureDTO {
    private Long id;
    private Long equipmentId;
    private String equipmentNombre;
    private LocalDateTime fechaReporte;
    private String descripcion;
    private String estado;
}
