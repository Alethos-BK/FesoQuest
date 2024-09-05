package org.back.domain.controller;

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
    public ResponseEntity<Questao> getQuestaoById(@PathVariable("id") int id) {
        Optional<Questao> questao = service.getQuestaoById(id);
        return questao.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Questao> createQuestao(@RequestBody Questao questao) {
        Questao savedQuestao = service.createQuestao(questao);
        return new ResponseEntity<>(savedQuestao, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> updateQuestao(@PathVariable("id") int id, @RequestBody Questao updatedQuestao) {
        Questao questao = service.updateQuestao(id, updatedQuestao);

        if (questao == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(questao, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteQuestao(@PathVariable("id") int id) {
        boolean wasDeleted = service.deleteQuestao(id);

        if (!wasDeleted) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}