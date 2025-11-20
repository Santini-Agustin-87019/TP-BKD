package com.tpi.backend.mscamiones.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContenedorEstadoDto {
    private Long identificacion;
    private String estado;
}
