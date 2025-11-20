package com.tpi.ms_operaciones.dto;

//import com.tpi.ms_operaciones.enums.EstadoSolicitud;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SolicitudResponse {

    private Long nroSolicitud;
    private Long clienteId;
    private Long contenedorId;
    private BigDecimal costoEstimado;
    private Integer tiempoEstimado;
    private BigDecimal costoFinal;
    private Integer tiempoReal;
    //private EstadoSolicitud estado;
}