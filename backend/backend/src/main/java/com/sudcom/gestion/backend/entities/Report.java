package com.sudcom.gestion.backend.entities;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reportes")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reporte")
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String contenido;

    @Column(name = "tipo_reporte")
    private String tipo;

    @Column(nullable = false)
    private LocalDate fechaGeneracion;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private User user;
}
