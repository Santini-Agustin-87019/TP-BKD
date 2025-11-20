package com.tpi.ms_recursos.service;

import com.tpi.ms_recursos.entity.Tarifa;
import com.tpi.ms_recursos.repository.TarifaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TarifaService {

    private final TarifaRepository tarifaRepository;

    public List<Tarifa> listar() {
        return tarifaRepository.findAll();
    }

    public Tarifa buscarPorId(Long id) {
        return tarifaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
    }

    // Crear o actualizar (si querés tener PUT sin path variable)
    public Tarifa guardar(Tarifa tarifa) {
        return tarifaRepository.save(tarifa);
    }

    public Tarifa actualizar(Long id, Tarifa nueva) {
        Tarifa actual = buscarPorId(id);
        //actual.setIdTipo(nueva.getIdTipo());
        actual.setCostoFijoGestion(nueva.getCostoFijoGestion());
        actual.setCostoFijoPorKm(nueva.getCostoFijoPorKm());
        actual.setValorCombustibleLitro(nueva.getValorCombustibleLitro());
        actual.setVigenciaDesde(nueva.getVigenciaDesde());
        actual.setVigenciaHasta(nueva.getVigenciaHasta());
        return tarifaRepository.save(actual);
    }

    public void eliminar(Long id) {
        tarifaRepository.deleteById(id);
    }
}