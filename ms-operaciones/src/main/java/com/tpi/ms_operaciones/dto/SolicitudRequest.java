package com.tpi.ms_operaciones.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class SolicitudRequest {

    @NotNull
    private Long clienteId;

    @NotNull
    private Long contenedorId;

    // Datos mínimos de origen y destino (después se pueden refinar)
    @NotNull
    private String origen;

    @NotNull
    private String destino;
}