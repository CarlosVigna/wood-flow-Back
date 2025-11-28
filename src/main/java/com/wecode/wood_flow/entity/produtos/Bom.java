package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "bom")
public class Bom {

    @EmbeddedId
    private BomId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProdutoPai")
    private Produtos produtoPai;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProdutoFilho")
    private Produtos produtoFilho;

    private BigDecimal quantidade;

    public Bom() {}

    public Bom(Produtos pai, Produtos filho, BigDecimal quantidade) {
        this.id = new BomId(pai.getId(), filho.getId());
        this.produtoPai = pai;
        this.produtoFilho = filho;
        this.quantidade = quantidade;
    }
}