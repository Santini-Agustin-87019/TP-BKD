package com.tpi.ms_recursos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // ¡Agregamos esto para el service!
// ¡AQUÍ ESTABA EL ERROR DE COMPILACIÓN!
import com.tpi.ms_recursos.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findByDocumento(String documento); // ¡Agregamos esto!
}