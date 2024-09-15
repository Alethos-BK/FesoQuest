package org.back.domain.controller;

import org.back.domain.enums.ETipoUsuario;
import org.back.domain.exception.CustomException;
import org.back.domain.service.UsuarioService;
import org.back.domain.usuario.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) throws CustomException {
        return new ResponseEntity<>(service.create(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") int id,
                                          @RequestBody Usuario updatedUsuario) throws CustomException {
        return ResponseEntity.ok(service.update(id, updatedUsuario));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
