package com.wecode.wood_flow.service;

import com.wecode.wood_flow.dto.request.ClientesRequestDTO;
import com.wecode.wood_flow.dto.response.ClientesResponseDTO;
import com.wecode.wood_flow.entity.Clientes;
import com.wecode.wood_flow.repositories.ClientesRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientesService {

    private final ClientesRepository repository;

    public ClientesService(ClientesRepository repository) {
        this.repository = repository;
    }

    public Clientes buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public List<Clientes> buscarTodos() {
        return repository.findAll();
    }

    @Transactional
    public ClientesResponseDTO create(ClientesRequestDTO dto) {


        Clientes cliente = new Clientes();
        cliente.setNome(dto.nome());
        cliente.setTelefone(dto.telefone());
        cliente.setEmail(dto.email());
        cliente.setEndereco(dto.endereco());
        cliente.setTipo(dto.tipo());
        cliente.setDocumento(dto.documento());

        Clientes salvo = repository.save(cliente);
        return new ClientesResponseDTO(salvo);
    }

    @Transactional
    public ClientesResponseDTO update(Long id, ClientesRequestDTO dto) {
        Clientes cliente = buscarPorId(id);

        if (dto.nome() != null) cliente.setNome(dto.nome());
        if (dto.telefone() != null) cliente.setTelefone(dto.telefone());
        if (dto.email() != null) cliente.setEmail(dto.email());
        if (dto.endereco() != null) cliente.setEndereco(dto.endereco());
        if (dto.tipo() != null) cliente.setTipo(dto.tipo());
        if (dto.documento() != null) cliente.setDocumento(dto.documento());

        Clientes atualizado = repository.save(cliente);
        return new ClientesResponseDTO(atualizado);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Cliente não encontrado para exclusão");
        }
        repository.deleteById(id);
    }
}