package com.sudcom.gestion.backend.entities;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mantenimientos")
public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mantenimiento")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_equipo", nullable = false)
    private Equipment equipment;

    @Column(name = "fecha_mantenimiento", nullable = false)
    private LocalDate fecha;

    private String responsable;

    @Column(name = "tipo_mantenimiento", nullable = false)
    private String tipoMantenimiento;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private String estado;
}
