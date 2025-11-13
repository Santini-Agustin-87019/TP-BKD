package com.tpi.ms_clientes.entity;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @Email
    @NotBlank
    private String email;

    private String telefono;
    @Past
    @Temporal(TemporalType.DATE)
    private Date fechaDeNacimiento;

    @NotNull
    private int dni;

    private Boolean activo;
    
    @Column(name = "fecha_creacion", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;
     @PrePersist
    public void prePersist() {
        this.fechaCreacion = new Date();
        if (this.activo == null) this.activo = true;
    }

    @PreUpdate
    public void preUpdate() {
        this.fechaModificacion = new Date();
    }

}
