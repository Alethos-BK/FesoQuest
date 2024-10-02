package org.back.domain.controller;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Alternativa;
import org.back.domain.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alternativas")
public class AlternativaController {

    @Autowired
    private AlternativaService alternativaService;

    @GetMapping
    public List<Alternativa> getAll() {
        return alternativaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(alternativaService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Alternativa> create(@RequestBody Alternativa alternativa) {
        return new ResponseEntity<>(alternativaService.create(alternativa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alternativa> update(@PathVariable("id") int id,
                                                         @RequestBody Alternativa updatedAlternativa) throws CustomException {
        return ResponseEntity.ok(alternativaService.update(id, updatedAlternativa));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        alternativaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}