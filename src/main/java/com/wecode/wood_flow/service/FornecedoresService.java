package com.wecode.wood_flow.service;

import com.wecode.wood_flow.dto.request.FornecedorRequestDTO;
import com.wecode.wood_flow.dto.response.FornecedorResponseDTO;
import com.wecode.wood_flow.entity.Fornecedores;
import com.wecode.wood_flow.repositories.FornecedoresRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedoresService {

    public final FornecedoresRepository repository;

    public FornecedoresService(FornecedoresRepository repository) {
        this.repository = repository;
    }

    public Fornecedores buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public List<Fornecedores> buscarTodos() {
        return repository.findAll();
    }

    public FornecedorResponseDTO criar(FornecedorRequestDTO dto){

        Fornecedores fornecedor = new Fornecedores();
        fornecedor.setNome(dto.nome());
        fornecedor.setTelefone(dto.telefone());
        fornecedor.setEmail(dto.email());
        fornecedor.setEndereco(dto.endereco());
        fornecedor.setCnpj(dto.cnpj());

        Fornecedores salvo = repository.save(fornecedor);
        return new FornecedorResponseDTO(salvo);

    }

    public FornecedorResponseDTO update(Long id, FornecedorRequestDTO dto) {

        Fornecedores fornecedor = buscarPorId(id);
        if (dto.nome() != null) fornecedor.setNome(dto.nome());
        if (dto.telefone() != null) fornecedor.setTelefone(dto.telefone());
        if (dto.email() != null) fornecedor.setEmail(dto.email());
        if (dto.endereco() != null) fornecedor.setEndereco(dto.endereco());
        if (dto.cnpj() != null) fornecedor.setCnpj(dto.cnpj());

        Fornecedores atualizado = repository.save(fornecedor);
        return new FornecedorResponseDTO(atualizado);
    }

    public void delete(Long id){
        if (!repository.existsById(id)){
            throw new RuntimeException("Fornecedor não encontrado para exclusão");
        }
        repository.deleteById(id);
    }

}
