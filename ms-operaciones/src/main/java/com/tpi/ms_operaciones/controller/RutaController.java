package com.tpi.ms_operaciones.controller;

import com.tpi.ms_operaciones.dto.RutaRequestDTO;
import com.tpi.ms_operaciones.entity.Ruta;
import com.tpi.ms_operaciones.service.RutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rutas") // URL base
public class RutaController {

    @Autowired
    private RutaService rutaService;

    // --- Endpoint para CREAR una Ruta Tentativa ---
    // URL: POST /rutas
    @PostMapping
    public ResponseEntity<?> generarRutaTentativa(@RequestBody RutaRequestDTO request) {
        try {
            Ruta nuevaRuta = rutaService.crearRutaTentativa(request);
            // Devolvemos un 200 OK con la ruta creada
            return ResponseEntity.ok(nuevaRuta);
        } catch (RuntimeException e) {
            // Si la solicitud no se encontró, devolvemos un 404
            return ResponseEntity.notFound().build();
        }
    }
}