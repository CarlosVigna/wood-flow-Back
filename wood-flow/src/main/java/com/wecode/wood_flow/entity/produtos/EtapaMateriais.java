package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "etapa_materiais")
@Getter
@Setter
public class EtapaMateriais {

    @EmbeddedId
    private EtapaMateriaisId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @ManyToOne
    @MapsId("idEtapa")
    @JoinColumn(name = "idEtapa")
    private Etapas etapa;

    @ManyToOne
    @MapsId("idProdutoFilho")
    @JoinColumn(name = "idProdutoFilho")
    private Produto produtoFilho;

    private BigDecimal quantidade;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "idProduto", insertable=false, updatable=false),
            @JoinColumn(name = "idEtapa", insertable=false, updatable=false)
    })
    private ProdutoEtapa produtoEtapa;
}