package org.back.src.controller;

import org.back.src.dto.UsuarioRequestDto;
import org.back.src.dto.UsuarioResponseDto;
import org.back.src.exception.CustomException;
import org.back.src.service.UsuarioService;
import org.back.src.entity.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<UsuarioResponseDto> getAll() {
        return usuarioService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(usuarioService.getById(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> create(@RequestBody UsuarioRequestDto usuario) throws CustomException {
        return new ResponseEntity<>(usuarioService.create(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") int id,
                                          @RequestBody UsuarioRequestDto updatedUsuario) throws CustomException {
        return ResponseEntity.ok(usuarioService.update(id, updatedUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        usuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
