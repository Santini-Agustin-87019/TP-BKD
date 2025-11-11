package com.tpi.msrecursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpi.msrecursos.entity.ConfiguracionCostos;

@Repository
public interface ConfiguracionCostosRepository extends JpaRepository<ConfiguracionCostos, Long> {
    // Spring ya nos da: save(), findById(), findAll(), etc.
}