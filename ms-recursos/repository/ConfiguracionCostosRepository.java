package com.tpi.ms_recursos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional; // ¡Agregamos esto para el service!
// ¡AQUÍ ESTABA EL ERROR DE COMPILACIÓN!
import com.tpi.ms_recursos.entity.ConfiguracionCostos;

@Repository
public interface ConfiguracionCostosRepository extends JpaRepository<ConfiguracionCostos, Long> {
    Optional<ConfiguracionCostos> findTopByOrderByVigenciaDesdeDesc(); // ¡Agregamos esto!
}