package com.tpi.ms_recursos.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tpi.ms_recursos.entity.Deposito; // ¡CON GUION BAJO!

@Repository
public interface DepositoRepository extends JpaRepository<Deposito, Long> {
}