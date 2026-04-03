package com.sudcom.gestion.backend.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentRequestDTO {
    private String nombre;
    private String codigo;
    private String ubicacion;
    private String estado;
    private String marca;
    private String modelo;
    private LocalDate fechaAdquisicion;
}
