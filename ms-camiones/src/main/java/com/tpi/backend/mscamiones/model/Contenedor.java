package com.tpi.backend.mscamiones.model;

import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "contenedores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Contenedor {

    @Id
    private Long identificacion;

    private Double volumen;
    private Double peso;

    @ManyToOne
    @JoinColumn(name = "estado_id")
    private EstadoContenedor estado;
}
