package com.tpi.ms_operaciones.entity;

import com.tpi.ms_operaciones.enums.EstadoTramo;
import com.tpi.ms_operaciones.enums.TipoTramo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "tramos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTramo;

    private String origen;   // podés usar dirección o "DEPOSITO X"
    private String destino;

    // Se agrega para calcular costos y tiempos
    private Double distanciaKm;

    private BigDecimal costoAproximado;
    private BigDecimal costoReal;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;

    // IDs de otros microservicios
    private Long camionId;      // MS Camiones
    

    @Enumerated(EnumType.STRING)
    private EstadoTramo estado;

    @Enumerated(EnumType.STRING)
    private TipoTramo tipo;

    @ManyToOne
    @JoinColumn(name = "ruta_id")
    private Ruta ruta;
}