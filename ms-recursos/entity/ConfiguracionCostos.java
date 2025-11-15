package com.tpi.ms_recursos.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "configuracion_costos")
@Data
@NoArgsConstructor
public class ConfiguracionCostos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double valorLitroCombustible;
    private double cargosGestionFijos; // Costo fijo por solicitud

    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;
}