package com.wecode.wood_flow.dto.request;

import java.math.BigDecimal;

public record BomRequestDTO(
        Long idProdutoPai,
        Long idProdutoFilho,
        BigDecimal quantidade
) {}