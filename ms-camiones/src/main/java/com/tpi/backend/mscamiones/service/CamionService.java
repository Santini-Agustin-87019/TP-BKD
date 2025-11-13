package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;

import java.util.List;

public interface CamionService {
    
    /**
     * Guarda un nuevo camión en la base de datos.
     * @param dto Los datos del camión a crear.
     * @return La entidad Camion guardada.
     * @throws jakarta.persistence.EntityNotFoundException si el transportistaId no existe.
     */
    Camion guardarCamion(CamionDto dto);

    /**
     * Lista todos los camiones o los filtra por estado.
     * @param estado El estado por el cual filtrar ("libre" u "ocupado"). Si es nulo, lista todos.
     * @return Una lista de camiones.
     */
    List<Camion> listar(String estado);
}