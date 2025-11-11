package com.tpi.msrecursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpi.msrecursos.entity.CostoBaseVolumen;

@Repository
public interface CostoBaseVolumenRepository extends JpaRepository<CostoBaseVolumen, Long> {
    // Spring ya nos da: save(), findById(), findAll(), etc.
}