package com.tpi.ms_recursos.service; // ¡CON GUION BAJO!

import com.tpi.ms_recursos.entity.Cliente;
import com.tpi.ms_recursos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    // Método con validación de documento duplicado
    public Cliente save(Cliente cliente) {
        if(clienteRepository.findByDocumento(cliente.getDocumento()).isPresent()) {
            throw new RuntimeException("Error: El documento " + cliente.getDocumento() + " ya existe.");
        }
        return clienteRepository.save(cliente);
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    // Método para buscar por documento
    public Optional<Cliente> findByDocumento(String documento) {
        return clienteRepository.findByDocumento(documento);
    }
}