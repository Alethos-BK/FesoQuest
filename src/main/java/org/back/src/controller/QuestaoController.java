package org.back.src.controller;

import org.back.src.dto.QuestaoRequestDto;
import org.back.src.dto.QuestaoResponseDto;
import org.back.src.exception.CustomException;
import org.back.src.entity.missoes.Questao;
import org.back.src.service.IAService;
import org.back.src.service.QuestaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    @Autowired
    private IAService iaService;

    @Autowired
    private QuestaoService questaoService;

    @GetMapping
    public List<QuestaoResponseDto> getAll() {
        return questaoService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestaoResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(questaoService.getById(id));
    }

    //todo ajustra para retornar um conjunto de questões
    @PostMapping("/questao-transformada")
    public ResponseEntity<String> getIaQuestions(@RequestBody String questao) {
        return ResponseEntity.ok(iaService.transformarQuestao(questao));
    }

    @PostMapping
    public ResponseEntity<Questao> create(@RequestBody QuestaoRequestDto questao) throws CustomException {
        return new ResponseEntity<>(questaoService.create(questao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Questao> update(@PathVariable("id") int id,
                                                 @RequestBody QuestaoRequestDto updatedQuestao) throws CustomException {
        return ResponseEntity.ok(questaoService.update(id, updatedQuestao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        questaoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}