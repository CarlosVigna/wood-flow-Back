package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="produtos")
@Getter
@Setter

public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    private String tipo;
    private String unidMedida;
    private BigDecimal custo;
    private BigDecimal ultimoCusto;
    private BigDecimal estoqueMinimo;
    private String localEstoque;
    private String cor;
    private BigDecimal precoA;
    private BigDecimal precoB;
    private BigDecimal altura;
    private BigDecimal largura;
    private BigDecimal profundidade;


    @OneToMany(mappedBy = "produtoPai", cascade = CascadeType.ALL)
    private List<Bom> componentes = new ArrayList<>();

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<ProdutoEtapa> etapas = new ArrayList<>();

}