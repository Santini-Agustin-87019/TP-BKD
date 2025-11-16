package com.tpi.ms_operaciones.dto;

import lombok.Data;

// Esto representa cada objeto dentro de la lista "tramos"
@Data
public class TramoDTO {
    private Long origenId;
    private Long destinoId;
    private String tipoDestino; // "DEPOSITO" o "CLIENTE"
    private Double distKm;
}