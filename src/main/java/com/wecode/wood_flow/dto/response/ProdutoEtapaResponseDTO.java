package com.wecode.wood_flow.dto.response;

import com.wecode.wood_flow.entity.produtos.ProdutoEtapa;
import java.time.Duration;

public record ProdutoEtapaResponseDTO(
    Long idProduto,
    Long idEtapa,
    Integer ordem,
    String setor,
    Duration tempoPrevisto
) {

    public ProdutoEtapaResponseDTO(ProdutoEtapa produtoEtapa) {
        this(
            produtoEtapa.getId().getIdProduto(),
            produtoEtapa.getId().getIdEtapa(),
            produtoEtapa.getOrdem(),
            produtoEtapa.getSetor(),
            produtoEtapa.getTempoPrevisto()
        );
    }
}