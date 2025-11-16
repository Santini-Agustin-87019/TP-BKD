package com.tpi.ms_operaciones.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "tramos")
@Data
@NoArgsConstructor
public class Tramo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Con esto, cada Tramo sabe a qué Ruta pertenece
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ruta_id")
    @JsonIgnore // Evita bucles infinitos al convertir a JSON
    private Ruta ruta;

    // Este ID viene de 'ms-camiones'
    private Long camionId; 

    // Este ID viene de 'ms-recursos'
    private Long depositoOrigenId;
    
    // Este ID puede ser de 'ms-recursos' (otro depósito) o 'ms-clientes'
    private Long destinoId;
    private String tipoDestino; // "DEPOSITO" o "CLIENTE"

    private Double distanciaKm;
    private String estado; // PENDIENTE, ASIGNADO, EN_CURSO, COMPLETADO
    
    private LocalDateTime fechaHoraInicio; // Cuándo marcó inicio
    private LocalDateTime fechaHoraFin; // Cuándo marcó fin

    public Tramo(Ruta ruta, Long depositoOrigenId, Long destinoId, String tipoDestino, Double distanciaKm) {
        this.ruta = ruta;
        this.depositoOrigenId = depositoOrigenId;
        this.destinoId = destinoId;
        this.tipoDestino = tipoDestino;
        this.distanciaKm = distanciaKm;
        this.estado = "PENDIENTE";
    }
}