package com.tpi.ms_operaciones.entity;

import com.tpi.ms_operaciones.enums.EstadoSolicitud;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "solicitudes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nroSolicitud;

    // IDs que vienen de otros microservicios
    private Long clienteId;
    private Long contenedorId;

    private BigDecimal costoEstimado;
    private BigDecimal costoFinal;

    private Integer tiempoEstimado; // en minutos
    private Integer tiempoReal;     // en minutos


    // Le agrego estado a la solicitud
    @Enumerated(EnumType.STRING)
    private EstadoSolicitud estado;

    // Relación con Ruta
    @OneToOne(mappedBy = "solicitud", cascade = CascadeType.ALL)
    private Ruta hojaDeRuta;
}