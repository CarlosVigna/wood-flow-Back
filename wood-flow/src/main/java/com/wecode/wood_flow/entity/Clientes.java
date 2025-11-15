package com.wecode.wood_flow.entity;

import com.wecode.wood_flow.request.ClientesRequestDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity(name="clientes")
@Table(name="clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;

    public Clientes(ClientesRequestDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
    }
}
