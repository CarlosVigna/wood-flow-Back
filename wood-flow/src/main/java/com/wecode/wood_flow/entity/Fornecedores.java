package com.wecode.wood_flow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "fornecedores")
@Getter
@Setter

public class Fornecedores extends Pessoa {
    private String cnpj;
}