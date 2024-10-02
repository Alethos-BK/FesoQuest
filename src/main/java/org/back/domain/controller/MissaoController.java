package org.back.domain.controller;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Missao;
import org.back.domain.service.MissaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissaoController {

    @Autowired
    private MissaoService missaoService;

    @GetMapping
    public List<Missao> getAll() {
        return missaoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Missao> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(missaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Missao> create(@RequestBody Missao missao) {
        return new ResponseEntity<>(missaoService.create(missao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> update(@PathVariable("id") int id,
                                               @RequestBody Missao updatedMissao) throws CustomException {
        return ResponseEntity.ok(missaoService.update(id, updatedMissao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        missaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}