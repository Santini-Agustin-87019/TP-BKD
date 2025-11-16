package com.tpi.backend.mscamiones.dto;

import lombok.Data;

@Data // Anotación de Lombok para getters, setters, etc.
public class EstadoCamionDto {
    
    // Este campo recibirá "libre" o "ocupado" desde el JSON
    private String estado;
}