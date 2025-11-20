package com.tpi.ms_operaciones.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
public class RutaResponse {
    private Long idRuta;
    private List<TramoDto> tramos;
    private BigDecimal costoTotalEstimado;
    private Integer tiempoTotalEstimado; // minutos
}