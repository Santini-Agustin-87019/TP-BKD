package com.tpi.msrecursos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity                 // 1. Le dice a JPA que esto es una entidad (una tabla)
@Table(name = "depositos") // 2. Le da el nombre "depositos" a la tabla en la BD
@Data                   // 3. Anotación de Lombok: crea getters, setters, toString(), etc.
@NoArgsConstructor      // 4. Anotación de Lombok: crea un constructor vacío (obligatorio para JPA)
public class Deposito {

    @Id // 5. Marca este campo como la Clave Primaria (PK)
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 6. Le dice a la BD que genere el ID automáticamente
    private Long id;

    private String nombre;
    private String direccion;
    private double latitud;
    private double longitud;
    
    // Este es el campo que definimos en nuestro diseño para el TPI
    private double costoEstadiaDia; 
}