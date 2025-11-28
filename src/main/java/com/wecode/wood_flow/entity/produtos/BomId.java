package com.wecode.wood_flow.entity.produtos;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BomId implements Serializable {

    @Column(name = "id_produto_pai")
    private Long idProdutoPai;

    @Column(name = "id_produto_filho")
    private Long idProdutoFilho;
}