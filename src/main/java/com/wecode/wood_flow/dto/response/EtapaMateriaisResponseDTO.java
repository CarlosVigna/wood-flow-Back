package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.produtos.EtapaMateriais;
import java.math.BigDecimal;

public record EtapaMateriaisResponseDTO(
        Long idProduto,
        Long idEtapa,
        Long idProdutoFilho,
        BigDecimal quantidade,
        String etapaNome,
        String produtoNome,
        String produtoFilhoNome
) {

    public EtapaMateriaisResponseDTO(EtapaMateriais etapaMateriais) {
        this(
                etapaMateriais.getId().getIdProduto(),
                etapaMateriais.getId().getIdEtapa(),
                etapaMateriais.getId().getIdProdutoFilho(),
                etapaMateriais.getQuantidade(),
                etapaMateriais.getEtapa().getNome(),
                etapaMateriais.getProduto().getDescricao(),
                etapaMateriais.getProdutoFilho().getDescricao()
        );
    }
}