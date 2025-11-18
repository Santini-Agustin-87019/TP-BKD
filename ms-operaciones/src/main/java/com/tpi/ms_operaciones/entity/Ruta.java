package com.tpi.ms_operaciones.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "rutas")
@Data
@NoArgsConstructor
public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relación con SolicitudTransporte (opcional, si la ruta está asociada a una solicitud)
    private Long solicitudTransporteId;

    // Lista de tramos que componen esta ruta
    @OneToMany(mappedBy = "ruta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tramo> tramos = new ArrayList<>();

    // Información general de la ruta
    private Double distanciaTotalKm;
    private String estado; // PLANIFICADA, EN_CURSO, COMPLETADA, CANCELADA
    
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinalizacion;

    // Constructor personalizado
    public Ruta(Long solicitudTransporteId) {
        this.solicitudTransporteId = solicitudTransporteId;
        this.estado = "PLANIFICADA";
        this.fechaCreacion = LocalDateTime.now();
        this.distanciaTotalKm = 0.0;
    }

    // Método helper para agregar tramos
    public void agregarTramo(Tramo tramo) {
        tramos.add(tramo);
        tramo.setRuta(this);
        if (tramo.getDistanciaKm() != null) {
            this.distanciaTotalKm += tramo.getDistanciaKm();
        }
    }

    // Método para calcular la distancia total
    public void calcularDistanciaTotal() {
        this.distanciaTotalKm = tramos.stream()
            .mapToDouble(tramo -> tramo.getDistanciaKm() != null ? tramo.getDistanciaKm() : 0.0)
            .sum();
    }
}
