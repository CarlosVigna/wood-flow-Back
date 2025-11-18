package com.wecode.wood_flow.dto;

import com.wecode.wood_flow.entity.Clientes;

public record ClientesResponseDTO(
        Long id,
        String nome,
        String documento,
        String tipoCliente,
        String telefone,
        String email,
        String endereco
) {
    public ClientesResponseDTO(Clientes cliente) {
        this(
            cliente.getId(),
            cliente.getNome(),
            resolveDocumento(cliente),
            resolveTipo(cliente),
            cliente.getTelefone(),
            cliente.getEmail(),
            cliente.getEndereco()
        );
    }

    private static String resolveDocumento(Clientes cliente) {
        if (cliente instanceof ClienteFisica f) {
            return f.getCpf();
        } else if (cliente instanceof ClienteJuridica j) {
            return j.getCnpj();
        }
        return null;
    }

    private static String resolveTipo(Clientes cliente) {
        if (cliente instanceof ClienteFisica) {
            return "FISICA";
        } else if (cliente instanceof ClienteJuridica) {
            return "JURIDICA";
        }
        return "DESCONHECIDO";
    }
}