//
// Esta es la línea que estaba mal en tu DepositoController.
//
package com.tpi.ms_recursos.controller; // ¡CON GUION BAJO!

import com.tpi.ms_recursos.entity.CostoBaseVolumen;
import com.tpi.ms_recursos.service.CostoBaseVolumenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/costos-volumen")
public class CostoBaseVolumenController {

    @Autowired
    private CostoBaseVolumenService service;

    @GetMapping
    public List<CostoBaseVolumen> findAll() {
        return service.findAll();
    }

    @PostMapping
    public CostoBaseVolumen save(@RequestBody CostoBaseVolumen costo) {
        return service.save(costo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CostoBaseVolumen> findById(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}