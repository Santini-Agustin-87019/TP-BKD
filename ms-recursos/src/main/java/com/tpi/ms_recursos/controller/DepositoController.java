//
// ¡ESTA ES LA CORRECCIÓN CLAVE PARA SWAGGER!
//
package com.tpi.ms_recursos.controller; // ¡CON GUION BAJO!

import com.tpi.ms_recursos.entity.Deposito;
import com.tpi.ms_recursos.service.DepositoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/depositos")
public class DepositoController {

    @Autowired
    private DepositoService depositoService;

    @GetMapping
    public List<Deposito> findAll() { return depositoService.findAll(); }

    @GetMapping("/{id}")
    public ResponseEntity<Deposito> findById(@PathVariable Long id) {
        return depositoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Deposito save(@RequestBody Deposito deposito) {
        return depositoService.save(deposito);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        depositoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}