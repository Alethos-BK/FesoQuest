package org.back.src.service;

import org.back.src.dto.UsuarioRequestDto;
import org.back.src.dto.UsuarioResponseDto;
import org.back.src.exception.CustomException;
import org.back.src.repository.UsuarioRepository;
import org.back.src.conversor.MapperConvert;
import org.back.src.entity.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioResponseDto> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios.stream().map(usuario ->
                MapperConvert.convert(usuario, UsuarioResponseDto.class)).toList();
    }

    public UsuarioResponseDto getById(int id) throws CustomException {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        return MapperConvert.convert(usuario, UsuarioResponseDto.class);
    }

    public Usuario create(UsuarioRequestDto usuarioRequestDto) throws CustomException {
        BCryptPasswordEncoder bcript = new BCryptPasswordEncoder();
        usuarioRequestDto.setSenha(bcript.encode(usuarioRequestDto.getSenha()));

        Usuario usuario = MapperConvert.convert(usuarioRequestDto, Usuario.class);
        return usuarioRepository.save(usuario);
    }

    public Usuario update(int id, UsuarioRequestDto usuarioRequestDto) throws CustomException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        Usuario usuario = MapperConvert.convert(usuarioRequestDto, Usuario.class);

        usuario.setId(id);
        return usuarioRepository.save(usuario);
    }

    public void delete(int id) throws CustomException {
        usuarioRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        usuarioRepository.deleteById(id);
    }
}
