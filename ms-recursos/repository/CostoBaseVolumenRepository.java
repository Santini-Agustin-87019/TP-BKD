package com.tpi.ms_recursos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tpi.ms_recursos.entity.CostoBaseVolumen;

@Repository
public interface CostoBaseVolumenRepository extends JpaRepository<CostoBaseVolumen, Long> {
}