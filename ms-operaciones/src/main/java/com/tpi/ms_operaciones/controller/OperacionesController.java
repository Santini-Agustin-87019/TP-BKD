package com.tpi.ms_operaciones.controller;

import com.tpi.ms_operaciones.dto.*;
import com.tpi.ms_operaciones.service.OperacionesService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OperacionesController {

    private final OperacionesService service;

    // Solicitudes

    @PostMapping("/solicitudes")
    public ResponseEntity<SolicitudResponse> crearSolicitud(
            @Valid @RequestBody SolicitudRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crearSolicitud(request));
    }

    @GetMapping("/solicitudes/{id}/costo")
    public ResponseEntity<CostoResponse> obtenerCosto(@PathVariable Long id) {
        return ResponseEntity.ok(service.obtenerCostoTotal(id));
    }

    // Rutas

    @PostMapping("/rutas/tentativas")
    public ResponseEntity<RutaResponse> generarRutaTentativa(
            @RequestParam Long solicitudId,
            @Valid @RequestBody RutaRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.generarRutaTentativa(request, solicitudId));
    }

    @GetMapping("/rutas/tentativas")
    public ResponseEntity<RutaResponse> consultarRutaTentativa(
            @RequestParam String origen,
            @RequestParam String destino) {
        return ResponseEntity.ok(service.consultarRutaTentativaPorOrigenDestino(origen, destino));
    }


    @PostMapping("/rutas/{solicitudId}/asignar")
    public ResponseEntity<Void> asignarRutaDefinitiva(@PathVariable Long solicitudId) {
        service.asignarRutaDefinitiva(solicitudId);
        return ResponseEntity.noContent().build();
    }

    // Tramos

    @PutMapping("/tramos/{id}/asignar-camion")
    public ResponseEntity<Void> asignarCamion(
            @PathVariable Long id,
            @RequestParam Long camionId) {
        service.asignarCamionATramo(id, camionId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tramos/{id}/inicio")
    public ResponseEntity<Void> marcarInicio(@PathVariable Long id) {
        service.marcarInicioTramo(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/tramos/{id}/fin")
    public ResponseEntity<Void> marcarFin(@PathVariable Long id) {
        service.marcarFinTramo(id);
        return ResponseEntity.noContent().build();
    }
}