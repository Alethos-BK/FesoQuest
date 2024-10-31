package org.back.src.party.controller;

import org.back.src.party.dto.PartyRequestDto;
import org.back.src.party.dto.PartyResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.party.entity.Party;
import org.back.src.party.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parties")
public class PartyController {

    @Autowired
    private PartyService partyService;

    @GetMapping
    public List<PartyResponseDto> getAll() {
        return partyService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PartyResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(partyService.getById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<Party> create(@RequestBody PartyRequestDto party) throws CustomException {
        return new ResponseEntity<>(partyService.create(party), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Party> update(@PathVariable("id") int id,
                                        @RequestBody PartyRequestDto updatedParty) throws CustomException {
        return new ResponseEntity<>(partyService.update(id, updatedParty), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        partyService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
