package org.back.domain.controller;

import org.back.domain.exception.CustomException;
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
    public ResponseEntity<Mesa> getMesaById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(mesaService.getMesaById(id));
    }

    @PostMapping
    public ResponseEntity<Mesa> createMesa(@RequestBody Mesa mesa) {
        return new ResponseEntity<>( mesaService.createMesa(mesa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> updateMesa(@PathVariable("id") int id,
                                           @RequestBody Mesa updatedMesa) throws CustomException {
        return new ResponseEntity<>(mesaService.updateMesa(id, updatedMesa), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMesa(@PathVariable("id") int id) throws CustomException {
        mesaService.deleteMesa(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
