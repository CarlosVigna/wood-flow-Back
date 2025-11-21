package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "etapas")
@Getter
@Setter
public class Etapas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtapa;

    @Column(nullable = false)
    private String nome;

    private String descricao;
}