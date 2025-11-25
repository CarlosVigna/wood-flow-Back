package com.wecode.wood_flow.repositories;

import com.wecode.wood_flow.entity.produtos.Bom;
import com.wecode.wood_flow.entity.produtos.BomId;
import com.wecode.wood_flow.entity.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BomRepository extends JpaRepository<Bom , BomId>{


        boolean existsByProdutoPai(Produtos produtoPai);
        boolean existsByProdutoFilho(Produtos produtoFilho);

}
