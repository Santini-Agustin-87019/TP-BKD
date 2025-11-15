//
// ¡LA LÍNEA MÁS IMPORTANTE!
// Asegurate que todos tus archivos nuevos usen el paquete CON guión bajo.
//
package com.tpi.ms_recursos.service;

import com.tpi.ms_recursos.entity.ConfiguracionCostos;
import com.tpi.ms_recursos.repository.ConfiguracionCostosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConfiguracionCostosService {

    @Autowired
    private ConfiguracionCostosRepository repository;

    // Método para crear/actualizar una configuración
    public ConfiguracionCostos save(ConfiguracionCostos configuracion) {
        // (Aquí podríamos agregar lógica para asegurarnos que
        // la nueva "vigenciaDesde" no se pise con otras)
        return repository.save(configuracion);
    }

    // Método para obtener la configuración vigente (la más nueva)
    public Optional<ConfiguracionCostos> getConfiguracionVigente() {
        return repository.findTopByOrderByVigenciaDesdeDesc();
    }
}