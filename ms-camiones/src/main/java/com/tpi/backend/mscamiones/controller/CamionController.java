package com.tpi.backend.mscamiones.controller;

import com.tpi.backend.mscamiones.dto.CamionDto;
import com.tpi.backend.mscamiones.model.Camion;
import com.tpi.backend.mscamiones.service.CamionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Camion>> listarCamiones(
            // @RequestParam mapea el parámetro de la URL (ej. ...?estado=libre)
            // 'required = false' significa que el parámetro es opcional.
            @RequestParam(name = "estado", required = false) String estado
    ) {
        // 1. Llamamos al servicio, que tiene toda la lógica.
        List<Camion> camiones = camionService.listar(estado);
        
        // 2. Respondemos "200 OK" con la lista de camiones.
        return ResponseEntity.ok(camiones);
    }
}