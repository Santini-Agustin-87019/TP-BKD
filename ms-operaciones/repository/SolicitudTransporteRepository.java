package com.tpi.ms_operaciones.repository;

import com.tpi.ms_operaciones.entity.SolicitudTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudTransporteRepository extends JpaRepository<SolicitudTransporte, Long> {

    // Spring Data JPA creará automáticamente estos métodos:
    
    // Método para buscar todas las solicitudes de un cliente específico
    List<SolicitudTransporte> findByClienteId(Long clienteId);

    // Método para buscar todas las solicitudes que estén en un estado (Ej: "PENDIENTE")
    List<SolicitudTransporte> findByEstado(String estado);
}