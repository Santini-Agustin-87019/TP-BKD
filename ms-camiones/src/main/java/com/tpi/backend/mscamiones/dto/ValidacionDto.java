package com.tpi.backend.mscamiones.dto;

import lombok.Data;

@Data
public class ValidacionDto {
    // Usamos 'dominio' como ID, como en el PUT anterior
    private String dominio; 
    private Double peso;
    private Double volumen;
}

