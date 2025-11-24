package com.wecode.wood_flow.dto.request;

public record FornecedorRequestDTO(

    String nome,
    String telefone,
    String email,
    String endereco,
    String cnpj
) {}
