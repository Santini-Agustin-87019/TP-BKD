package com.tpi.backend.mscamiones.dto;

import lombok.Data;

@Data // Anotación de Lombok para getters, setters, etc.
public class CamionDto {
    
    // Esta es la Primary Key, la proveemos nosotros
    private String dominio; 
    
    private Double capPesoKg;
    private Double capVolumenM3;
    private Double consumoKm;
    private Double costoBaseKm;
    
    // Esta es la FK que acordamos agregar
    private Long transportistaId; 
}