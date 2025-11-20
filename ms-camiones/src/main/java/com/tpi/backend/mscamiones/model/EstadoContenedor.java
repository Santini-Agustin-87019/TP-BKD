package com.tpi.backend.mscamiones.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "estado_contenedor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstadoContenedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    private String descripcion;
}
