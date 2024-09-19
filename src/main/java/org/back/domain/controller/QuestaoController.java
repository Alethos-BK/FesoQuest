package org.back.domain.controller;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Questao;
import org.back.domain.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<Questao> getAll() {
        return questaoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(questaoService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Questao> create(@RequestBody Questao questao) {
        return new ResponseEntity<>(questaoService.create(questao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(@PathVariable("id") int id,
                                                 @RequestBody Questao updatedQuestao) throws CustomException {
        return ResponseEntity.ok(questaoService.update(id, updatedQuestao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        questaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}