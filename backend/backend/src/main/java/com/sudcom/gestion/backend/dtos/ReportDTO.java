package com.sudcom.gestion.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReportDTO {
    private Long id;
    private Long userId;
    private String userNombre;
    private String titulo;
    private String tipo;
    private LocalDateTime fechaGeneracion;
    private String contenido;
}
