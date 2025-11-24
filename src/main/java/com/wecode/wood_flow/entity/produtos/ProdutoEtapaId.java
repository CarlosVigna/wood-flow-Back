package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class ProdutoEtapaId implements Serializable {

    private Long idProduto;
    private Long idEtapa;

    public ProdutoEtapaId() {}

    public ProdutoEtapaId(Long idProduto, Long idEtapa) {
        this.idProduto = idProduto;
        this.idEtapa = idEtapa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProdutoEtapaId)) return false;
        ProdutoEtapaId that = (ProdutoEtapaId) o;
        return Objects.equals(idProduto, that.idProduto) &&
               Objects.equals(idEtapa, that.idEtapa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduto, idEtapa);
    }
}