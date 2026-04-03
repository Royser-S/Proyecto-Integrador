package com.sudcom.gestion.backend.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReportResponseDTO {
    private Long id;
    private Long idUsuario;
    private String nombreUsuario;
    private String titulo;
    private String tipoReporte;
    private LocalDate fechaGeneracion;
    private String contenido;
}
