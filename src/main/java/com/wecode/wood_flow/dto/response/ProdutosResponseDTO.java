package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.produtos.Produtos;
import java.math.BigDecimal;
import java.util.List;

public record ProdutosResponseDTO(
        Long id,
        String descricao,
        String tipo,
        String unidMedida,
        BigDecimal custo,
        BigDecimal ultimoCusto,
        BigDecimal estoqueMinimo,
        String localEstoque,
        String cor,
        BigDecimal precoA,
        BigDecimal precoB,
        BigDecimal altura,
        BigDecimal largura,
        BigDecimal profundidade,

        List<BomResponseDTO> componentes,
        List<ProdutoEtapaResponseDTO> etapas
) {

    public ProdutosResponseDTO(Produtos produto) {
        this(
                produto.getId(),
                produto.getDescricao(),
                produto.getTipo(),
                produto.getUnidMedida(),
                produto.getCusto(),
                produto.getUltimoCusto(),
                produto.getEstoqueMinimo(),
                produto.getLocalEstoque(),
                produto.getCor(),
                produto.getPrecoA(),
                produto.getPrecoB(),
                produto.getAltura(),
                produto.getLargura(),
                produto.getProfundidade(),

                produto.getComponentes()
                        .stream()
                        .map(BomResponseDTO::new)
                        .toList(),

                produto.getEtapas()
                        .stream()
                        .map(ProdutoEtapaResponseDTO::new)
                        .toList()
        );
    }
}