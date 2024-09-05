package org.back.domain.controller;

import org.back.domain.missoes.Missao;
import org.back.domain.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService service;

    @GetMapping
    public List<Missao> getAllMissoes() {
        return service.getAllMissoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Missao> getMissaoById(@PathVariable("id") int id) {
        Optional<Missao> missao = service.getMissaoById(id);
        return missao.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Missao> createMissao(@RequestBody Missao missao) {
        Missao savedMissao = service.createMissao(missao);
        return new ResponseEntity<>(savedMissao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> updateMissao(@PathVariable("id") int id, @RequestBody Missao updatedMissao) {
        Missao missao = service.updateMissao(id, updatedMissao);

        if (missao == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(missao, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissao(@PathVariable("id") int id) {
        boolean wasDeleted = service.deleteMissao(id);

        if (!wasDeleted) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}