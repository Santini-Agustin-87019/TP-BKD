package com.tpi.backend.mscamiones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor // Útil para crear la respuesta fácilmente
public class ValidacionResponseDto {
    
    private boolean ok;
    private String motivo;
}