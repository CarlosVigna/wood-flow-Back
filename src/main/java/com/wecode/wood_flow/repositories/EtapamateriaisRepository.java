package com.wecode.wood_flow.repositories;

import com.wecode.wood_flow.entity.produtos.EtapaMateriais;
import com.wecode.wood_flow.entity.produtos.EtapaMateriaisId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtapamateriaisRepository extends JpaRepository<EtapaMateriais, EtapaMateriaisId> {
}
