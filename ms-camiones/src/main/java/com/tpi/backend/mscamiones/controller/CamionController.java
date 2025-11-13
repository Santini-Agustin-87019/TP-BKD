package com.tpi.backend.mscamiones.controller;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;
import com.tpi.backend.mscamiones.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
// Usamos /api/v1/ para versionar la API.
@RequestMapping("/api/v1/camiones") 
public class CamionController {

    // 1. Inyectamos el Servicio
    @Autowired
    private CamionService camionService;

    // 2. Creamos el endpoint POST según tu diseño
    @PostMapping
    public ResponseEntity<Camion> crearCamion(@RequestBody CamionDto dto) {
        // 3. Llamamos al servicio para hacer el trabajo
        Camion nuevoCamion = camionService.guardarCamion(dto);
        
        // 4. Respondemos con "200 OK" y el camión creado
        return ResponseEntity.ok(nuevoCamion);
    }
}