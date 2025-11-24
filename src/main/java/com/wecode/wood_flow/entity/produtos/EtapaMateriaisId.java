package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class EtapaMateriaisId implements Serializable {

    private Long idProduto;
    private Long idEtapa;
    private Long idProdutoFilho;

    public EtapaMateriaisId() {}

    public EtapaMateriaisId(Long idProduto, Long idEtapa, Long idProdutoFilho) {
        this.idProduto = idProduto;
        this.idEtapa = idEtapa;
        this.idProdutoFilho = idProdutoFilho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EtapaMateriaisId that)) return false;
        return Objects.equals(idProduto, that.idProduto) &&
               Objects.equals(idEtapa, that.idEtapa) &&
               Objects.equals(idProdutoFilho, that.idProdutoFilho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idEtapa, idProdutoFilho);
    }
}