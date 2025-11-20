package com.tpi.ms_operaciones.dto;

import lombok.Data;

@Data
public class RutaRequest {
    private String origen;
    private String destino;
    // después podríamos agregar depósitos opcionales, etc.
}