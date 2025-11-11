package com.tpi.msrecursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpi.msrecursos.entity.Deposito;

@Repository // 1. Le dice a Spring que esto es un componente de persistencia
public interface DepositoRepository extends JpaRepository<Deposito, Long> {
    
    // 2. JpaRepository<Deposito, Long> significa:
    // "Voy a gestionar la entidad 'Deposito', cuya clave primaria (ID) es de tipo 'Long'"
    
    // ¡Y eso es todo! 
    // Spring Data JPA nos regala automáticamente métodos como:
    // - save()
    // - findById()
    // - findAll()
    // - deleteById()
    // ...y muchos más.
}