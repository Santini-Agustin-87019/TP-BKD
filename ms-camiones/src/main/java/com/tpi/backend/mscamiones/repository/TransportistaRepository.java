package com.tpi.backend.mscamiones.repository;

import com.tpi.backend.mscamiones.model.Transportista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz de Repositorio para la entidad Transportista.
 * Spring Data JPA implementará automáticamente los métodos de esta interfaz.
 */
@Repository // Anotación que le indica a Spring que esto es un componente de repositorio.
public interface TransportistaRepository extends JpaRepository<Transportista, Long> {
    
    // --- ¿Qué significa JpaRepository<Transportista, Long>? ---
    // 1. Transportista: Es la entidad que este repositorio manejará.
    // 2. Long: Es el tipo de dato de la Primary Key (PK) de Transportista (el campo 'id').

    // ¡Y eso es todo! 
    // Por el simple hecho de existir, esta interfaz ya nos da MÁGICAMENTE métodos como:
    // - save(Transportista entity) -> Guarda o actualiza un transportista.
    // - findById(Long id) -> Busca un transportista por su ID.
    // - findAll() -> Devuelve una lista de todos los transportistas.
    // - deleteById(Long id) -> Borra un transportista.
}