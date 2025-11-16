package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;
import com.tpi.backend.mscamiones.dto.ValidacionDto;
import com.tpi.backend.mscamiones.dto.ValidacionResponseDto;

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

    /**
     * Actualiza el estado de disponibilidad de un camión.
     * @param dominio El dominio (PK) del camión a actualizar.
     * @param estado El nuevo estado ("libre" u "ocupado").
     * @return El camión con su estado actualizado.
     */
    Camion actualizarEstado(String dominio, String estado);

    /**
     * Valida si un camión puede transportar una carga específica.
     * @param dto Contiene el dominio, peso y volumen a validar.
     * @return Un DTO con el resultado de la validación.
     */
    ValidacionResponseDto validarCapacidad(ValidacionDto dto);
}