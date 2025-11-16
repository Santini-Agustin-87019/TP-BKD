package com.tpi.ms_operaciones.service;

import com.tpi.ms_operaciones.dto.RutaRequestDTO;
import com.tpi.ms_operaciones.dto.TramoDTO;
import com.tpi.ms_operaciones.entity.Ruta;
import com.tpi.ms_operaciones.entity.SolicitudTransporte;
import com.tpi.ms_operaciones.entity.Tramo;
import com.tpi.ms_operaciones.repository.RutaRepository;
import com.tpi.ms_operaciones.repository.SolicitudTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Autowired
    private SolicitudTransporteRepository solicitudRepository;

    // Usamos @Transactional para que, si algo falla, no guarde nada (o todo o nada)
    @Transactional
    public Ruta crearRutaTentativa(RutaRequestDTO request) {
        
        // 1. Buscamos la solicitud de transporte
        SolicitudTransporte solicitud = solicitudRepository.findById(request.getSolicitudId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada con ID: " + request.getSolicitudId()));

        // 2. Creamos la nueva Ruta
        Ruta nuevaRuta = new Ruta(solicitud);

        // 3. Calculamos totales (distancia y costo)
        double distanciaTotal = 0;
        for (TramoDTO tramoDTO : request.getTramos()) {
            distanciaTotal += tramoDTO.getDistKm();
        }
        
        // (A futuro, aquí multiplicamos la distancia por el costo de ms-recursos)
        nuevaRuta.setDistanciaTotalKm(distanciaTotal);
        nuevaRuta.setCostoTotalEstimado(distanciaTotal * 150.0); // Costo hardcodeado por ahora
        
        // 4. Guardamos la ruta (para que tenga un ID)
        Ruta rutaGuardada = rutaRepository.save(nuevaRuta);

        // 5. Creamos y asociamos los Tramos
        for (TramoDTO tramoDTO : request.getTramos()) {
            Tramo nuevoTramo = new Tramo(
                    rutaGuardada,
                    tramoDTO.getOrigenId(),
                    tramoDTO.getDestinoId(),
                    tramoDTO.getTipoDestino(),
                    tramoDTO.getDistKm()
            );
            // Agregamos el tramo a la lista de la ruta
            rutaGuardada.getTramos().add(nuevoTramo); 
            // OJO: No necesitamos guardar el tramo por separado
            // gracias al CascadeType.ALL en la entidad Ruta
        }
        
        // 6. Actualizamos el estado de la solicitud
        solicitud.setEstado("APROBADA");
        solicitudRepository.save(solicitud);

        // 7. Guardamos la ruta de nuevo (ahora con los tramos)
        return rutaRepository.save(rutaGuardada);
    }
}