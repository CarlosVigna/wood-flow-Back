package com.wecode.wood_flow.repositories;

import com.wecode.wood_flow.entity.produtos.Produtos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {

}
