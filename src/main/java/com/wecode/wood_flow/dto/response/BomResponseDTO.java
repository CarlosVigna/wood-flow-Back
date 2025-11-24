package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.produtos.Bom;
import java.math.BigDecimal;

public record BomResponseDTO(
        Long idProdutoPai,
        Long idProdutoFilho,
        BigDecimal quantidade
) {
    public BomResponseDTO(Bom bom) {
        this(
                bom.getId().getIdProdutoPai(),
                bom.getId().getIdProdutoFilho(),
                bom.getQuantidade()
        );
    }
}