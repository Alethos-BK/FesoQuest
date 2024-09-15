package org.back.domain.controller;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Questao;
import org.back.domain.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private QuestaoService service;

    @GetMapping
    public List<Questao> getAllQuestoes() {
        return service.getAllQuestoes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> getQuestaoById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(service.getQuestaoById(id));
    }

    @PostMapping
    public ResponseEntity<Questao> createQuestao(@RequestBody Questao questao) {
        return new ResponseEntity<>(service.createQuestao(questao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> updateQuestao(@PathVariable("id") int id,
                                                 @RequestBody Questao updatedQuestao) throws CustomException {
        return ResponseEntity.ok(service.updateQuestao(id, updatedQuestao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestao(@PathVariable("id") int id) throws CustomException {
        service.deleteQuestao(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}