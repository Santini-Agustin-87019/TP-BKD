package com.tpi.ms_clientes.service;

import com.tpi.ms_clientes.entity.Cliente;
import com.tpi.ms_clientes.repository.ClienteRepository;
import com.tpi.ms_clientes.dto.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import lombok.RequiredArgsConstructor;
import java.util.List;

@Service @RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repo;

    public List<Cliente> listar() {
        return repo.findAll();
    }

    public Cliente buscar(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public ClienteResponse crear(ClienteRequest in) {
        Cliente c = repo.save(Cliente.builder()
                .nombre(in.getNombre())
                .apellido(in.getApellido())
                .email(in.getEmail())
                .telefono(in.getTelefono())
                .fechaDeNacimiento(in.getFechaDeNacimiento())
                .dni(in.getDni())
                .build());
        return toDto(c);
    }

    public ClienteResponse actualizar(Integer id, ClienteRequest in) {
        Cliente c = buscar(id);
        c.setNombre(in.getNombre());
        c.setApellido(in.getApellido());
        c.setEmail(in.getEmail());
        c.setTelefono(in.getTelefono());
        c.setFechaDeNacimiento(in.getFechaDeNacimiento());
        c.setDni(in.getDni());
        return toDto(repo.save(c));
    }

    public void eliminar(Integer id) {
        if (!repo.existsById(id)) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        repo.deleteById(id);
    }

    private ClienteResponse toDto(Cliente c) {
        return ClienteResponse.builder()
                .id(c.getId())
                .nombre(c.getNombre())
                .apellido(c.getApellido())
                .email(c.getEmail())
                .telefono(c.getTelefono())
                .dni(c.getDni())
                .build();
    }
}
