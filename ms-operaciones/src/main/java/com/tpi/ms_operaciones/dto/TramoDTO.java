package com.tpi.ms_operaciones.dto;

import com.tpi.ms_operaciones.enums.TipoTramo;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TramoDto {
    private Long id;
    private String origen;
    private String destino;
    private Double distanciaKm;
    private BigDecimal costoAproximado;
    private TipoTramo tipo;
}