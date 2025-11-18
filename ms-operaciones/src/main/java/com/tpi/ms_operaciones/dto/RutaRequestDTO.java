package com.tpi.ms_operaciones.dto;

import lombok.Data;
import java.util.List;

@Data
public class RutaRequestDTO {
    private Long solicitudId;
    private List<TramoDTO> tramos;
}