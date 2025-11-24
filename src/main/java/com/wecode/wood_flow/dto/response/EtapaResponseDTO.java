package com.wecode.wood_flow.dto.response;
import com.wecode.wood_flow.entity.produtos.Bom;
import com.wecode.wood_flow.entity.produtos.Etapas;

import java.math.BigDecimal;

public record EtapaResponseDTO(
        Long id,
        String nome,
        String descricao
) {
    public EtapaResponseDTO(Etapas etapa) {
        this(
            etapa.getId(),
            etapa.getNome(),
            etapa.getDescricao()
        );
    }
}   