package com.tpi.ms_operaciones.repository;

import com.tpi.ms_operaciones.entity.Tramo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TramoRepository extends JpaRepository<Tramo, Long> {
    
    // Método para buscar todos los tramos de un camión
    List<Tramo> findByCamionId(Long camionId);
}