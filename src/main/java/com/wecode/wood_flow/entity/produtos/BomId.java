package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class BomId implements Serializable {

    private Long idProdutoPai;
    private Long idProdutoFilho;

    public BomId() {}

    public BomId(Long idProdutoPai, Long idProdutoFilho) {
        this.idProdutoPai = idProdutoPai;
        this.idProdutoFilho = idProdutoFilho;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BomId bomId)) return false;
        return Objects.equals(idProdutoPai, bomId.idProdutoPai) &&
               Objects.equals(idProdutoFilho, bomId.idProdutoFilho);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProdutoPai, idProdutoFilho);
    }
}