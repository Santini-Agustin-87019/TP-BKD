package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.TransportistaDto;
import com.tpi.backend.mscamiones.model.Transportista;

public interface TransportistaService {

    /**
     * Guarda un nuevo transportista en la base de datos.
     * @param dto Los datos del transportista a crear.
     * @return La entidad Transportista guardada.
     */
    Transportista guardarTransportista(TransportistaDto dto);
}