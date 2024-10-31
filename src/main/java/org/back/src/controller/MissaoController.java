package org.back.src.controller;

import org.back.src.dto.MissaoRequestDto;
import org.back.src.dto.MissaoResponseDto;
import org.back.src.exception.CustomException;
import org.back.src.entity.missoes.Missao;
import org.back.src.service.MissaoService;
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
    public List<MissaoResponseDto> getAll() {
        return missaoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(missaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Missao> create(@RequestBody MissaoRequestDto missao) {
        return new ResponseEntity<>(missaoService.create(missao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Missao> update(@PathVariable("id") int id,
                                               @RequestBody MissaoRequestDto updatedMissao) throws CustomException {
        return ResponseEntity.ok(missaoService.update(id, updatedMissao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        missaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}