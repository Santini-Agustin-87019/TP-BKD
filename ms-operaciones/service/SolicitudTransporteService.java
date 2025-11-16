package com.tpi.ms_operaciones.service;

import com.tpi.ms_operaciones.entity.SolicitudTransporte;
import com.tpi.ms_operaciones.repository.SolicitudTransporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SolicitudTransporteService {

    @Autowired
    private SolicitudTransporteRepository repository;

    // Método para crear una NUEVA solicitud
    public SolicitudTransporte crearSolicitud(SolicitudTransporte solicitud) {
        // Por ahora, solo la guardamos.
        // MÁS ADELANTE, aquí llamaremos a ms-recursos y ms-camiones
        // para validar al cliente, calcular costos y asignar un camión.
        
        // Asignamos valores por defecto al crearla
        solicitud.setEstado("PENDIENTE");
        solicitud.setFechaSolicitud(java.time.LocalDateTime.now());
        
        return repository.save(solicitud);
    }

    // Método para obtener una solicitud por ID
    public Optional<SolicitudTransporte> getById(Long id) {
        return repository.findById(id);
    }

    // Método para obtener todas las solicitudes
    public List<SolicitudTransporte> getAll() {
        return repository.findAll();
    }

    // Método para obtener solicitudes por estado (Ej: "PENDIENTE")
    public List<SolicitudTransporte> getByEstado(String estado) {
        return repository.findByEstado(estado);
    }
}