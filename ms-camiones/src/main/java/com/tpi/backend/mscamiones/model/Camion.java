package com.tpi.backend.mscamiones.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entidad que mapea la tabla 'camiones' en la base de datos.
 */
@Entity
@Table(name = "camiones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Camion {

    @Id // Marca este campo como la Primary Key (PK)[cite: 227].
    // NOTA: No usamos @GeneratedValue. El 'dominio' (patente) es una PK natural,
    // la proveeremos nosotros, no se genera automáticamente.
    @Column(name = "dominio")
    private String dominio; // [cite: 227]

    // --- Nota de Diseño ---
    // Tu diagrama [cite: 228] muestra un campo 'capacidad'.
    // Sin embargo, el enunciado [cite: 17, 76, 101] requiere explícitamente
    // validar por "peso" y "volumen" por separado.
    // Por lo tanto, creamos ambos campos para cumplir las reglas de negocio.
    
    @Column(name = "capacidad_peso_kg")
    private Double capacidadPeso; // Capacidad máxima de carga en Kg[cite: 17, 76, 101].

    @Column(name = "capacidad_volumen_m3")
    private Double capacidadVolumen; // Capacidad máxima de carga en m3[cite: 17, 76, 101].

    @Column(name = "consumo_combustible_km")
    private Double consumo; // Consumo en L/km[cite: 229, 68].

    @Column(name = "costo_base_km")
    private Double costoBaseKm; // Costo por km[cite: 232, 67].
    
    @Column(name = "disponible")
    private Boolean disponibilidad; // [cite: 231]

    // --- Relación con Transportista ---
    
    @ManyToOne(fetch = FetchType.EAGER) // Muchos camiones (@Many) pueden pertenecer a Un transportista (@One).
    @JoinColumn(name = "id_transportista", referencedColumnName = "id")
    // Define la columna FK 'id_transportista' en esta tabla ('camiones')
    // que referencia a la columna 'id' de la tabla 'transportistas'.
    private Transportista transportista;
}