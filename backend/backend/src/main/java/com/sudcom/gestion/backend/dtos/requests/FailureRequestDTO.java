package com.sudcom.gestion.backend.dtos.requests;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FailureRequestDTO {
    private Long idEquipo;
    private Long idUsuario;
    private String descripcion;
    private String estado;
    private LocalDateTime fechaReporte;
}
