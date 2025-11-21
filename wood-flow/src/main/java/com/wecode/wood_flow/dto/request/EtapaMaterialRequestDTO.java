package com.wecode.wood_flow.dto.request;

import java.math.BigDecimal;

public record EtapaMaterialRequestDTO(
        Long idProdutoFilho,
        BigDecimal quantidade
) {}