package org.back.domain.controller;

import org.back.domain.exception.CustomException;
import org.back.domain.mesa.Mesa;
import org.back.domain.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mesas")
public class MesaController {

    @Autowired
    private MesaService mesaService;

    @GetMapping
    public List<Mesa> getAll() {
        return mesaService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mesa> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(mesaService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Mesa> create(@RequestBody Mesa mesa) {
        return new ResponseEntity<>(mesaService.create(mesa), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mesa> update(@PathVariable("id") int id,
                                           @RequestBody Mesa updatedMesa) throws CustomException {
        return new ResponseEntity<>(mesaService.update(id, updatedMesa), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        mesaService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
