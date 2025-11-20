package com.tpi.ms_recursos.controller;

import com.tpi.ms_recursos.entity.Tarifa;
import com.tpi.ms_recursos.service.TarifaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarifas")
@RequiredArgsConstructor
public class TarifaController {

    private final TarifaService tarifaService;

    // extra: listar para probar rápido
    @GetMapping
    @PreAuthorize("hasRole('operador')")
    public ResponseEntity<List<Tarifa>> listar() {
        return ResponseEntity.ok(tarifaService.listar());
    }

    // extra: crear (te sirve para cargar tarifas)
    @PostMapping
    @PreAuthorize("hasRole('operador')")
    public ResponseEntity<Tarifa> crear(@RequestBody Tarifa tarifa) {
        return ResponseEntity.ok(tarifaService.guardar(tarifa));
    }

    // lo que pide la tabla: actualizar tarifas
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('operador')")
    public ResponseEntity<Tarifa> actualizar(
            @PathVariable Long id,
            @RequestBody Tarifa tarifa) {

        Tarifa actualizada = tarifaService.actualizar(id, tarifa);
        return ResponseEntity.ok(actualizada);
    }
}