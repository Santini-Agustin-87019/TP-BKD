package com.tpi.ms_operaciones.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class CostoResponse {
    private Long solicitudId;
    private BigDecimal costoEstimado;
    private BigDecimal costoReal;
}