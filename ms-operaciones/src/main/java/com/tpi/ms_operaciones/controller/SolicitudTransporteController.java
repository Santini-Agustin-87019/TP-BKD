package com.tpi.ms_operaciones.controller;

import com.tpi.ms_operaciones.entity.SolicitudTransporte;
import com.tpi.ms_operaciones.service.SolicitudTransporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/solicitudes") // URL base
public class SolicitudTransporteController {

    @Autowired
    private SolicitudTransporteService service;

    // --- Endpoint para CREAR una nueva solicitud ---
    // URL: POST /solicitudes
    @PostMapping
    public SolicitudTransporte crearNuevaSolicitud(@RequestBody SolicitudTransporte solicitud) {
        // @RequestBody toma el JSON del cliente y lo convierte a un objeto SolicitudTransporte
        return service.crearSolicitud(solicitud);
    }

    // --- Endpoint para OBTENER TODAS las solicitudes ---
    // URL: GET /solicitudes
    @GetMapping
    public List<SolicitudTransporte> getAllSolicitudes() {
        return service.getAll();
    }

    // --- Endpoint para OBTENER una solicitud por ID ---
    // URL: GET /solicitudes/1
    @GetMapping("/{id}")
    public ResponseEntity<SolicitudTransporte> getSolicitudById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok) // Si la encuentra, devuelve 200 OK con la solicitud
                .orElse(ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // --- Endpoint para OBTENER solicitudes por ESTADO ---
    // URL: GET /solicitudes/estado?q=PENDIENTE
    @GetMapping("/estado")
    public List<SolicitudTransporte> getSolicitudesPorEstado(@RequestParam("q") String estado) {
        return service.getByEstado(estado);
    }
}