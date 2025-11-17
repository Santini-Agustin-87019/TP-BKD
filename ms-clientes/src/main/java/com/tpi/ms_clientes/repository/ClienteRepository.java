package com.tpi.ms_clientes.repository;
import com.tpi.ms_clientes.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    
}
