//
// ¡Asegurate que todos tus archivos nuevos usen el paquete CON guión bajo!
//
package com.tpi.ms_recursos.service;

import com.tpi.ms_recursos.entity.CostoBaseVolumen;
import com.tpi.ms_recursos.repository.CostoBaseVolumenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostoBaseVolumenService {

    @Autowired
    private CostoBaseVolumenRepository repository;

    public List<CostoBaseVolumen> findAll() {
        return repository.findAll();
    }

    public Optional<CostoBaseVolumen> findById(Long id) {
        return repository.findById(id);
    }

    public CostoBaseVolumen save(CostoBaseVolumen costo) {
        // Aquí podríamos agregar la validación de que los rangos no se pisen
        // (Ej: que volMin < volMax)
        return repository.save(costo);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}