package com.sudcom.gestion.backend.entities;

import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "equipos")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_equipo")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigo;

    private String marca;
    private String modelo;
    private LocalDate fechaAdquisicion;
    private String ubicacion;
    private String estado;

    @OneToMany(mappedBy = "equipment", cascade = CascadeType.ALL)
    private List<Maintenance> maintenances;
}
