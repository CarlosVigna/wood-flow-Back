package com.wecode.wood_flow.repositories;

import com.wecode.wood_flow.entity.produtos.ProdutoEtapa;
import com.wecode.wood_flow.entity.produtos.ProdutoEtapaId;
import com.wecode.wood_flow.entity.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoEtapaRepository extends JpaRepository<ProdutoEtapa, ProdutoEtapaId>{

    boolean existsByProduto(Produtos produto);
}
