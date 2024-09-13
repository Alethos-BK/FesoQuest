package org.back.domain.service;

import org.back.domain.repository.UsuarioRepository;
import org.back.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Usuario> getById(int id) {
        return usuarioRepository.findById(id);
    }

    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario update(int id, Usuario updatedUser) {
        if (!usuarioRepository.existsById(id)) {
            return null;
        }

        updatedUser.setId(id);
        return usuarioRepository.save(updatedUser);
    }

    public boolean delete(int id) {
        if (!usuarioRepository.existsById(id)) {
            return false;
        }

        usuarioRepository.deleteById(id);
        return true;
    }
}
