package com.tpi.ms_recursos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tarifas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarifa;              // PK

    // idTipo no lo usamos, mas adelante vemos si lo usamos o no
    // private Long idTipo;

    private BigDecimal costoFijoGestion;
    private BigDecimal costoFijoPorKm;
    private BigDecimal valorCombustibleLitro;

    private LocalDate vigenciaDesde;
    private LocalDate vigenciaHasta;

}
