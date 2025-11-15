package com.tpi.ms_recursos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String documento; // CUIT/CUIL
    private String email;
    private String telefono;
    
    // NOTA: La contraseña no va aquí.
    // La autenticación la maneja Keycloak, como pide el TPI.
    // Aquí solo guardamos los datos de contacto.
}