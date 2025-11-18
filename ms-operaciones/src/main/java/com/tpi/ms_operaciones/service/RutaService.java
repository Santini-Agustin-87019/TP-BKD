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
        Ruta nuevaRuta = new Ruta(solicitud.getId());

        // 3. Calculamos totales (distancia y costo)
        double distanciaTotal = 0;
        for (TramoDTO tramoDTO : request.getTramos()) {
            distanciaTotal += tramoDTO.getDistKm();
        }
        
        // (A futuro, aquí multiplicamos la distancia por el costo de ms-recursos)
        nuevaRuta.setDistanciaTotalKm(distanciaTotal);
        
        // 4. Creamos y asociamos los Tramos usando el método helper
        for (TramoDTO tramoDTO : request.getTramos()) {
            Tramo nuevoTramo = new Tramo(
                    nuevaRuta,
                    tramoDTO.getOrigenId(),
                    tramoDTO.getDestinoId(),
                    tramoDTO.getTipoDestino(),
                    tramoDTO.getDistKm()
            );
            // Usamos el método helper de la entidad Ruta
            nuevaRuta.agregarTramo(nuevoTramo);
        }
        
        // 5. Actualizamos el estado de la solicitud
        solicitud.setEstado("APROBADA");
        solicitudRepository.save(solicitud);

        // 6. Guardamos la ruta (ahora con los tramos gracias a CascadeType.ALL)
        return rutaRepository.save(nuevaRuta);
    }
}