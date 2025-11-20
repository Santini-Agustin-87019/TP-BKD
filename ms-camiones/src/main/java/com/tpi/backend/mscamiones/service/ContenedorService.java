package com.tpi.backend.mscamiones.service;
import com.tpi.backend.mscamiones.dto.ContenedorEstadoDto;


public interface ContenedorService {
    ContenedorEstadoDto obtenerEstado(Long id);
}
