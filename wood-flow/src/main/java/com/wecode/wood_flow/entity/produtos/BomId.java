package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class BomId implements Serializable {
    private Long idProdutoPai;
    private Long idProdutoFilho;
}