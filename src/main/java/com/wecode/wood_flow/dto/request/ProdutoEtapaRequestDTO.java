package com.wecode.wood_flow.dto.request;

import java.time.Duration;

public record ProdutoEtapaRequestDTO(
    Long idProduto,
    Long idEtapa,
    Integer ordem,
    String setor,
    Duration tempoPrevisto
) {}