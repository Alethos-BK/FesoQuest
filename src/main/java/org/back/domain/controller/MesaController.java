package org.back.domain.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.back.domain.mesa.Mesa;
import org.back.domain.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> getAllMesas() {
        return mesaService.getAllMesas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getMesaById(@PathVariable("id") int id) {
        Optional<Mesa> mesa = mesaService.getMesaById(id);
        return mesa.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody Mesa mesa) {
        Mesa savedMesa = mesaService.createMesa(mesa);
        return new ResponseEntity<>(savedMesa, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable("id") int id, @RequestBody Mesa updatedMesa) {
        Mesa mesa = mesaService.updateMesa(id, updatedMesa);

        if (mesa == null) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(mesa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable("id") int id) {
        boolean wasDeleted = mesaService.deleteMesa(id);

        if (!wasDeleted) {
            return ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
