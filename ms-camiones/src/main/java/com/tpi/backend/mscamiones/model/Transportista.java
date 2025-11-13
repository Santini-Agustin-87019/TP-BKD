package com.tpi.backend.mscamiones.model;

import jakarta.persistence.*; // Importa las anotaciones de JPA
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate; // Usamos el tipo moderno para fechas

/**
 * Entidad que mapea la tabla 'transportistas' en la base de datos.
 * Representa a un chofer o transportista.
 */
@Entity // Le dice a JPA que esta clase es una entidad que debe ser persistida.
@Table(name = "transportistas") // Define el nombre de la tabla en la base de datos.
@Data // Anotación de Lombok: genera Getters, Setters, toString(), etc.
@NoArgsConstructor // Lombok: genera un constructor sin argumentos (requerido por JPA).
@AllArgsConstructor // Lombok: genera un constructor con todos los argumentos.
public class Transportista {

    @Id // Marca este campo como la Primary Key (PK)[cite: 211].
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Le dice a la BD que genere este valor automáticamente (auto-incremental).
    private Long id; // [cite: 211]

    @Column(name = "licencia") // Mapea este campo a una columna[cite: 212].
    private String licencia; // [cite: 212]

    @Column(name = "fecha_vencimiento_licencia") // Nombra la columna en snake_case.
    private LocalDate fechaVencimientoLicencia; // [cite: 214]

    @Column(name = "id_usuario_keycloak", unique = true) // El ID de Keycloak debe ser único.
    private String idUsuarioKeycloak; // [cite: 214]

    // La relación @OneToMany (un transportista tiene muchos camiones)
    // la configuraremos desde el lado de Camion (@ManyToOne) 
    // para mantener la simplicidad.
}