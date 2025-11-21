package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class ProdutoEtapaId implements Serializable {
    private Long idProduto;
    private Long idEtapa;
}
