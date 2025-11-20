package com.tpi.backend.mscamiones.service;
import com.tpi.backend.mscamiones.dto.ContenedorEstadoDto;
import com.tpi.backend.mscamiones.model.Contenedor;
import com.tpi.backend.mscamiones.repository.ContenedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContenedorServiceImpl implements ContenedorService {

    @Autowired
    private ContenedorRepository contenedorRepository;

    @Override
    public ContenedorEstadoDto obtenerEstado(Long id) {

        Contenedor contenedor = contenedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contenedor no encontrado"));

        return new ContenedorEstadoDto(
                contenedor.getIdentificacion(),
                contenedor.getEstado().getDescripcion()
        );
    }
}
