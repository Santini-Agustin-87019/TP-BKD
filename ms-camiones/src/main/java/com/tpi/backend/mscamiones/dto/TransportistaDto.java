package com.tpi.backend.mscamiones.dto;

import lombok.Data;
import java.time.LocalDate;

@Data // Anotación de Lombok para getters, setters, etc.
public class TransportistaDto {

    // No incluimos el ID, la BD lo genera
    private String licencia;
    private LocalDate fechaVencimientoLicencia;
    private String idUsuarioKeycloak;
}