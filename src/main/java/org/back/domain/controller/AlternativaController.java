package org.back.domain.controller;

import org.back.domain.missoes.Alternativa;
import org.back.domain.service.AlternativaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alternativas")
public class AlternativaController {

    @Autowired
    private AlternativaService service;

    @GetMapping
    public List<Alternativa> getAllAlternativas() {
        return service.getAllAlternativas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alternativa> getAlternativaById(@PathVariable("id") int id) {
        Optional<Alternativa> alternativa = service.getAlternativaById(id);
        return alternativa.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Alternativa> createAlternativa(@RequestBody Alternativa alternativa) {
        Alternativa savedAlternativa = service.createAlternativa(alternativa);
        return new ResponseEntity<>(savedAlternativa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Alternativa> updateAlternativa(@PathVariable("id") int id, @RequestBody Alternativa updatedAlternativa) {
        Alternativa alternativa = service.updateAlternativa(id, updatedAlternativa);

        if (alternativa == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(alternativa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlternativa(@PathVariable("id") int id) {
        boolean wasDeleted = service.deleteAlternativa(id);

        if (!wasDeleted) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}