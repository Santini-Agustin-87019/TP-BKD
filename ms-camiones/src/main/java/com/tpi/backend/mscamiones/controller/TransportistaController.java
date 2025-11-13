package com.tpi.backend.mscamiones.controller;

import com.tpi.backend.mscamiones.dto.TransportistaDto;
import com.tpi.backend.mscamiones.model.Transportista;
import com.tpi.backend.mscamiones.service.TransportistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Le dice a Spring que esto es un Controlador REST
@RequestMapping("/api/v1/transportistas") // La URL base
public class TransportistaController {

    // 1. Inyectamos el Servicio que acabamos de crear
    @Autowired
    private TransportistaService transportistaService;

    // 2. Creamos el endpoint POST
    @PostMapping
    public ResponseEntity<Transportista> crearTransportista(@RequestBody TransportistaDto dto) {
        
        // 3. Llamamos al servicio para guardar
        Transportista nuevoTransportista = transportistaService.guardarTransportista(dto);
        
        // 4. Respondemos con "200 OK" y el objeto creado
        return ResponseEntity.ok(nuevoTransportista);
    }
}