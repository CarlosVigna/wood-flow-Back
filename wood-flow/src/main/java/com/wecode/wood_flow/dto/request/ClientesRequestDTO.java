package com.wecode.wood_flow.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientesRequestDTO(
        @NotBlank String nome,
        @NotBlank String documento,
        String telefone,
        String email,
        String endereco
) {}