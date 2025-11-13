package com.tpi.backend.mscamiones.service;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;
import com.tpi.backend.mscamiones.model.Transportista;
import com.tpi.backend.mscamiones.repository.CamionRepository;
import com.tpi.backend.mscamiones.repository.TransportistaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service // Le dice a Spring que esta es una clase de Servicio
public class CamionServiceImpl implements CamionService {

    // 1. Inyectamos los dos repositorios que necesitamos
    @Autowired
    private CamionRepository camionRepository;
    
    @Autowired
    private TransportistaRepository transportistaRepository;

    @Override
    public Camion guardarCamion(CamionDto dto) {
        
        // 2. Lógica Clave: Buscar al transportista por su ID
        Transportista transportista = transportistaRepository.findById(dto.getTransportistaId())
            .orElseThrow(() -> new EntityNotFoundException(
                "No se encontró el transportista con ID: " + dto.getTransportistaId()
            ));

        // 3. Crear la nueva entidad Camion
        Camion nuevoCamion = new Camion();
        
        // 4. Mapear los datos del DTO a la Entidad
        nuevoCamion.setDominio(dto.getDominio());
        nuevoCamion.setCapacidadPeso(dto.getCapPesoKg());
        nuevoCamion.setCapacidadVolumen(dto.getCapVolumenM3());
        nuevoCamion.setConsumo(dto.getConsumoKm());
        nuevoCamion.setCostoBaseKm(dto.getCostoBaseKm());
        
        // 5. Regla de Negocio: Un camión nuevo siempre está disponible
        nuevoCamion.setDisponibilidad(true); 
        
        // 6. Asignar la relación que encontramos
        nuevoCamion.setTransportista(transportista);
        
        // 7. Guardar la nueva entidad en la base de datos
        return camionRepository.save(nuevoCamion);
    }

    @Override
    public List<Camion> listar(String estado) {
        
        // 1. Si el 'estado' no se proporciona (es nulo), devolvemos TODOS.
        if (Objects.isNull(estado)) {
            return camionRepository.findAll();
        }

        // 2. Si se proporciona, traducimos el texto.
        if (estado.equalsIgnoreCase("libre")) {
            // 3. Usamos el nuevo método del repositorio.
            return camionRepository.findAllByDisponibilidad(true);
        } else if (estado.equalsIgnoreCase("ocupado")) {
            // 4. Usamos el nuevo método del repositorio.
            return camionRepository.findAllByDisponibilidad(false);
        }

        // 5. Si el estado es cualquier otra cosa (ej. "roto"), 
        // devolvemos una lista vacía.
        return List.of(); 
    }
}