package com.tpi.ms_operaciones_entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "solicitudes_transporte")
@Data
@NoArgsConstructor
public class SolicitudTransporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- 1. Datos del Cliente ---
    // Este ID viene del microservicio 'ms-clientes'
    // Guardamos solo el ID para mantener los microservicios desacoplados
    private Long clienteId; 

    // --- 2. Datos de la Carga ---
    private String descripcionCarga;
    private double pesoCargaKg;
    private double volumenCargaM3;

    // --- 3. Datos del Origen y Destino ---
    private String direccionOrigen;
    private String direccionDestino;
    // (Podríamos agregar lat/lon de origen y destino más adelante)

    // --- 4. Datos de la Fecha ---
    private LocalDateTime fechaSolicitud; // Cuándo se creó la solicitud
    private LocalDateTime fechaHoraRetiro; // Cuándo hay que buscarla

    // --- 5. Estado y Costo ---
    private String estado; // Ej: PENDIENTE, APROBADA, RECHAZADA, EN_PROCESO, COMPLETADA
    private Double costoTotal; // Se calculará después

    // --- Constructor (útil para cuando creamos una nueva) ---
    public SolicitudTransporte(Long clienteId, String descripcionCarga, double pesoCargaKg, double volumenCargaM3,
                               String direccionOrigen, String direccionDestino, LocalDateTime fechaHoraRetiro) {
        this.clienteId = clienteId;
        this.descripcionCarga = descripcionCarga;
        this.pesoCargaKg = pesoCargaKg;
        this.volumenCargaM3 = volumenCargaM3;
        this.direccionOrigen = direccionOrigen;
        this.direccionDestino = direccionDestino;
        this.fechaHoraRetiro = fechaHoraRetiro;
        
        // Valores por defecto al crearla
        this.fechaSolicitud = LocalDateTime.now();
        this.estado = "PENDIENTE"; // Siempre empieza como pendiente
    }
}