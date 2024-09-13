package org.back.domain.controller;

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
    public ResponseEntity<Usuario> getById(@PathVariable("id") int id) {
        Optional<Usuario> usuario = service.getById(id);
        return usuario.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        Usuario savedQuestao = service.create(usuario);
        return new ResponseEntity<>(savedQuestao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable("id") int id, @RequestBody Usuario updatedUsuario) {
        Usuario usuario = service.update(id, updatedUsuario);

        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        boolean wasDeleted = service.delete(id);

        if (!wasDeleted) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
