package com.tpi.ms_operaciones.repository;

import com.tpi.ms_operaciones.entity.Ruta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RutaRepository extends JpaRepository<Ruta, Long> {
    
    // Método para buscar una ruta por el ID de la solicitud
    Optional<Ruta> findBySolicitudId(Long solicitudId);
}