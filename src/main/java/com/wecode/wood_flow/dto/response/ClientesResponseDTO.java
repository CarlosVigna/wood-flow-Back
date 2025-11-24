package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.Clientes;
import com.wecode.wood_flow.enums.TipoPessoa;

public record ClientesResponseDTO(
        Long id,
        String nome,
        String documento,
        TipoPessoa tipo,
        String telefone,
        String email,
        String endereco
) {
    public ClientesResponseDTO(Clientes cliente) {
        this(
                cliente.getId(),
                cliente.getNome(),
                cliente.getDocumento(),
                cliente.getTipo(),
                cliente.getTelefone(),
                cliente.getEmail(),
                cliente.getEndereco()
        );
    }
}