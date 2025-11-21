package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name="bom")
@Getter
@Setter

public class Bom {

    @EmbeddedId
    private BomId id;

    @ManyToOne
    @MapsId("idProdutoPai")
    @JoinColumn(name="idProdutoPai")
    private Produto produtoPai;

    @ManyToOne
    @MapsId("idProdutoFilho")
    @JoinColumn(name="idProdutoFilho")
    private Produto produtoFilho;

    @Column(nulllable = false)
    private BigDecimal quantidade;
}