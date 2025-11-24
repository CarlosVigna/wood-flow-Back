package com.wecode.wood_flow.repositories;

import com.wecode.wood_flow.entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {
}
