package com.tpi.backend.mscamiones.controller;
import com.tpi.backend.mscamiones.dto.ContenedorEstadoDto;
import com.tpi.backend.mscamiones.service.ContenedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contenedores")
public class ContenedorController {

    @Autowired
    private ContenedorService contenedorService;

    @GetMapping("/{id}/estado")
    public ResponseEntity<ContenedorEstadoDto> obtenerEstado(@PathVariable Long id) {
        return ResponseEntity.ok(contenedorService.obtenerEstado(id));
    }
}
