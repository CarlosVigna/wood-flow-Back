package com.wecode.wood_flow.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity(name="produtos")
@Table(name="produtss")
@AllArgsConstructor
@Setter
@Getter

public class Produtos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private String unid_medida;
    private ver custo;
    private ver ultimo_custo;
    private ver estoque_minimo;
    private String local_estoque;
    private String cor;
    private ver precoA;
    private ver precoB;
    private ver altura;
    private ver largura;
    private ver profundidade;

}
