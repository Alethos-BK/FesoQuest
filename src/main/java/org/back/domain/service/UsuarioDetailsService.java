package org.back.domain.service;

import org.back.domain.repository.UsuarioRepository;
import org.back.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String matricula) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByMatricula(matricula)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + matricula));
        return usuario;
    }

}
