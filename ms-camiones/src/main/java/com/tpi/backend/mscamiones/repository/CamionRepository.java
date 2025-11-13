package com.tpi.backend.mscamiones.repository;

import com.tpi.backend.mscamiones.model.Camion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Interfaz de Repositorio para la entidad Camion.
 */
@Repository
public interface CamionRepository extends JpaRepository<Camion, String> {


    // --- ¿Qué significa JpaRepository<Camion, String>? ---
    // 1. Camion: Es la entidad que este repositorio manejará.
    // 2. String: Es el tipo de dato de la Primary Key (PK) de Camion (el campo 'dominio').

    // De nuevo, ya tenemos:
    // - save(Camion entity)
    // - findById(String dominio)
    // - findAll()
    // - deleteById(String dominio)
    // ...y muchos más.

    /**
     * Busca todos los camiones que coincidan con un estado de disponibilidad.
     * Spring Data JPA "entiende" este nombre de método y genera la consulta:
     * "SELECT * FROM camiones WHERE disponible = ?"
     * * @param disponibilidad true para 'libre', false para 'ocupado'
     * @return Una lista de camiones que coinciden con el estado.
     */
    List<Camion> findAllByDisponibilidad(Boolean disponibilidad);
}