package com.tpi.ms_clientes.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ClienteResponse {
    private Integer id;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Integer dni;
}