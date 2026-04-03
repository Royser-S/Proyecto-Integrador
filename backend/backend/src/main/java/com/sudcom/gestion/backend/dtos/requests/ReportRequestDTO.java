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
public class ReportRequestDTO {
    private Long idUsuario;
    private String titulo;
    private String tipoReporte;
    private String contenido;
    private LocalDate fechaGeneracion;
}
