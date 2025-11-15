package com.tpi.ms_recursos.service;

import com.tpi.ms_recursos.entity.Deposito;
import com.tpi.ms_recursos.repository.DepositoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 1. Le dice a Spring que esta clase es un "Servicio"
public class DepositoService {

    // 2. Inyectamos el Repositorio que creamos antes
    @Autowired
    private DepositoRepository depositoRepository;

    // 3. Método para obtener TODOS los depósitos
    public List<Deposito> findAll() {
        return depositoRepository.findAll();
    }

    // 4. Método para obtener un depósito por su ID
    public Optional<Deposito> findById(Long id) {
        return depositoRepository.findById(id);
    }

    // 5. Método para GUARDAR un nuevo depósito
    public Deposito save(Deposito deposito) {
        // Aquí podríamos agregar lógica de negocio
        // (Ej: validar que el nombre no esté repetido)
        return depositoRepository.save(deposito);
    }

    // 6. Método para BORRAR un depósito
    public void deleteById(Long id) {
        depositoRepository.deleteById(id);
    }
}