package com.tpi.ms_operaciones.repository;

import com.tpi.ms_operaciones.entity.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {
}