//
// ¡LA LÍNEA MÁS IMPORTANTE!
// Esta es la línea que estaba mal en tu DepositoController.
//
package com.tpi.ms_recursos.controller; // ¡CON GUION BAJO!

import com.tpi.ms_recursos.entity.ConfiguracionCostos;
import com.tpi.ms_recursos.service.ConfiguracionCostosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/configuracion-costos")
public class ConfiguracionCostosController {

    @Autowired
    private ConfiguracionCostosService service;

    // Endpoint para obtener la configuración MÁS RECIENTE (vigente)
    // GET /configuracion-costos/vigente
    @GetMapping("/vigente")
    public ResponseEntity<ConfiguracionCostos> getConfigVigente() {
        return service.getConfiguracionVigente()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Endpoint para CREAR una nueva configuración de costos
    // POST /configuracion-costos
    @PostMapping
    public ConfiguracionCostos save(@RequestBody ConfiguracionCostos configuracion) {
        return service.save(configuracion);
    }
}