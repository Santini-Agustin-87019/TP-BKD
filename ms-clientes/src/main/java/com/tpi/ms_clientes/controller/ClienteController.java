package com.tpi.ms_clientes.controller;

import com.tpi.ms_clientes.dto.*;
import com.tpi.ms_clientes.entity.Cliente;
import com.tpi.ms_clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.Map;


import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
@RequiredArgsConstructor
public class ClienteController {
    private final ClienteService service;

    @GetMapping
    public ResponseEntity<?> listar() { 
        List<Cliente> clientes = service.listar();
        if (clientes.isEmpty()) {
            return ResponseEntity.ok(Map.of("message", "No se encontraron clientes"));
        }
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public Cliente detalle(@PathVariable Integer id) { return service.buscar(id); }

    @PostMapping
    public ResponseEntity<ClienteResponse> crear(@Valid @RequestBody ClienteRequest in) {
        ClienteResponse c = service.crear(in);
        return ResponseEntity.created(URI.create("/api/v1/clientes/" + c.getId())).body(c);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponse> actualizar(@PathVariable Integer id, @Valid @RequestBody ClienteRequest in) {
        return ResponseEntity.ok(service.actualizar(id, in));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
