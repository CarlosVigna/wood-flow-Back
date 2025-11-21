package com.wecode.wood_flow.dto.request;

import java.math.BigDecimal;
import java.util.List;

public record ProdutosRequestDTO(
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

        List<BomRequestDTO> bom,
        List<EtapaRequestDTO> etapas
) {}