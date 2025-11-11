package com.tpi.msrecursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tpi.msrecursos.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Spring ya nos da: save(), findById(), findAll(), etc.
}