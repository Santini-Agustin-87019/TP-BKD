package com.tpi.ms_operaciones.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @OneToOne
    @JoinColumn(name = "solicitud_id")
    private Solicitud solicitud;

    private int cantidadTramos;
    private int cantidadDepositos;

    //cascade si eliminar una ruta, eliminar tambien sus tramos
    //orphanRemoval para eliminar tramos que ya no esten asociados a ninguna ruta
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Tramo> tramos = new ArrayList<>();
}