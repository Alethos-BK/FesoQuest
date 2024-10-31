package org.back.src.question.controller;

import org.back.src.question.dto.QuestionRequestDto;
import org.back.src.question.dto.QuestionResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.question.entity.Question;
import org.back.src.question.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/questoes")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping
    public List<QuestionResponseDto> getAll() {
        return questionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(questionService.getById(id));
    }

    //todo ajustra para retornar um conjunto de questões
    @PostMapping("/transformed-question")
    public ResponseEntity<String> getIaQuestions(@RequestBody String question) {
        return ResponseEntity.ok("");
    }

    @PostMapping
    public ResponseEntity<Question> create(@RequestBody QuestionRequestDto question) throws CustomException {
        return new ResponseEntity<>(questionService.create(question), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> update(@PathVariable("id") int id,
                                           @RequestBody QuestionRequestDto updatedQuestion) throws CustomException {
        return ResponseEntity.ok(questionService.update(id, updatedQuestion));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        questionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}