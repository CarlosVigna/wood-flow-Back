package com.wecode.wood_flow.dto.request;

import com.wecode.wood_flow.enums.TipoPessoa;

public record ClientesRequestDTO(
        String nome,
        String documento,
        String telefone,
        String email,
        String endereco,
        TipoPessoa tipo
) {}