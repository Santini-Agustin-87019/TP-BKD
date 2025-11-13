package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.TransportistaDto;
import com.tpi.backend.mscamiones.model.Transportista;
import com.tpi.backend.mscamiones.repository.TransportistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // Le dice a Spring que esto es un Servicio
public class TransportistaServiceImpl implements TransportistaService {

    // 1. Inyectamos el Repositorio que SÍ tenías
    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public Transportista guardarTransportista(TransportistaDto dto) {
        
        // 2. Creamos la entidad
        Transportista transportista = new Transportista();
        
        // 3. Mapeamos los datos del DTO a la Entidad
        transportista.setLicencia(dto.getLicencia());
        transportista.setFechaVencimientoLicencia(dto.getFechaVencimientoLicencia());
        transportista.setIdUsuarioKeycloak(dto.getIdUsuarioKeycloak());
        
        // 4. Usamos el repositorio para guardar en la BD
        return transportistaRepository.save(transportista);
    }
}