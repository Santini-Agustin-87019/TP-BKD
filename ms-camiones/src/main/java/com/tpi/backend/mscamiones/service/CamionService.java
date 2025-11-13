package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;

public interface CamionService {
    
    /**
     * Guarda un nuevo camión en la base de datos.
     * @param dto Los datos del camión a crear.
     * @return La entidad Camion guardada.
     * @throws jakarta.persistence.EntityNotFoundException si el transportistaId no existe.
     */
    Camion guardarCamion(CamionDto dto);
}