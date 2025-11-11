package com.tpi.msrecursos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "costos_base_volumen")
@Data
@NoArgsConstructor
public class CostoBaseVolumen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double volumenMinM3; // Ej: 0
    private double volumenMaxM3; // Ej: 10
    private double costoPorKm;   // Ej: 300 (para contenedores chicos)

    // Otro registro en esta tabla podría ser:
    // { id: 2, volumenMinM3: 10.1, volumenMaxM3: 30, costoPorKm: 450 }
}