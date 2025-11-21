package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "produto_etapas")
@Getter
@Setter
public class ProdutoEtapa {

    @EmbeddedId
    private ProdutoEtapaId id;

    @ManyToOne
    @MapsId("idProduto")
    @JoinColumn(name = "idProduto")
    private Produto produto;

    @ManyToOne
    @MapsId("idEtapa")
    @JoinColumn(name = "idEtapa")
    private Etapas etapa;

    private Integer ordem;
    private String setor;

    private Duration tempoPrevisto;


    @OneToMany(mappedBy = "produtoEtapa", cascade = CascadeType.ALL)
    private List<EtapaMateriais> materiais = new ArrayList<>();
}