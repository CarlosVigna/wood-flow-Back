package com.wecode.wood_flow.infrastructure.repository;

import com.wecode.wood_flow.infrastructure.entitys.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByEmail(String email);

    @Transactional
    void deleteByEmail(String email);

    <T> ScopedValue<T> findAllById(Integer id);
}
