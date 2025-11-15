package com.wecode.wood_flow.dto;

import com.wecode.wood_flow.entity.Clientes;

public record ClientesResponseDTO(Long id, String nome, String cpf) {

    public ClientesResponseDTO(Clientes clientes){
        this(clientes.getId(),
                clientes.getNome(),
                clientes.getCpf());
    }
}
