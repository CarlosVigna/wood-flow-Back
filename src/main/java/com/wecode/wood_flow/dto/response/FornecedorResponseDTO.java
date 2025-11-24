package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.Fornecedores;
public record FornecedorResponseDTO(
    Long id,
    String nome,
    String cnpj,
    String telefone,
    String email,
    String endereco
     
    
) { 

    public FornecedorResponseDTO (Fornecedores fornecedor){
        this(
            fornecedor.getId(),
            fornecedor.getNome(),
            fornecedor.getCnpj(),
            fornecedor.getTelefone(),
            fornecedor.getEmail(),
            fornecedor.getEndereco()
        );
    }

}
