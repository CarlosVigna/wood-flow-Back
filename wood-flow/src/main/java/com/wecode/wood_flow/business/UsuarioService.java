package com.wecode.wood_flow.business;


import com.wecode.wood_flow.infrastructure.entitys.Usuario;
import com.wecode.wood_flow.infrastructure.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repository;


    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
    }

    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("Email não encontrado")
                );
    }

public void deletarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
}

public void atualizarUsuarioPorId(Integer id, Usuario usuario) {
        Usuario  usuarioEntity = repository.findAllById(id).orElseThrow (() ->
        new RuntimeException("Usuario não encontrado"));
        Usuario usuarioAtualizado = Usuario.builder()
                .nome(usuario.getNome() != null ? usuario.getNome() :
                        usuarioEntity.getNome())
    .email(usuario.getEmail() != null ? usuario.getEmail() :
            usuarioEntity.getEmail())
                .build()


}

}
