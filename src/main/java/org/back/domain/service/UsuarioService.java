package org.back.domain.service;

import org.back.domain.enums.ETipoUsuario;
import org.back.domain.exception.CustomException;
import org.back.domain.repository.UsuarioRepository;
import org.back.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getAll() {
        return usuarioRepository.findAll();
    }

    public Usuario getById(int id) throws CustomException {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    public Usuario create(Usuario usuario) throws CustomException {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(int id, Usuario updatedUser) throws CustomException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        updatedUser.setId(id);
        return usuarioRepository.save(updatedUser);
    }

    public void delete(int id) throws CustomException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        usuarioRepository.deleteById(id);
    }
}
