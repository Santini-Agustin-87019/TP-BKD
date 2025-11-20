package com.tpi.backend.mscamiones.repository;
import com.tpi.backend.mscamiones.model.Contenedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContenedorRepository extends JpaRepository<Contenedor, Long> {
}
