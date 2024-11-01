package org.back.src.repository;

import org.back.src.entity.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByMatricula(String matricula);

}
