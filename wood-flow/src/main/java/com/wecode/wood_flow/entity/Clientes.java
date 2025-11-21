package com.wecode.wood_flow.entity;

import com.wecode.wood_flow.enums.TipoPessoa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter
public class Clientes extends Pessoa {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoPessoa tipo;

    @Column(nullable = false, unique = true)
    private String documento;
}