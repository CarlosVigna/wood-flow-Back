package com.wecode.wood_flow.dto.response;
import com.wecode.wood_flow.entity.produtos.Bom;
import java.math.BigDecimal;

public record EtapaResponseDTO(
        Long id,
        String nome,
        Integer ordem
) {
    public EtapaResponseDTO(Etapa etapa) {
        this(
            etapa.getId(),
            etapa.getNome(),
            etapa.getOrdem()
        );
    }
}   