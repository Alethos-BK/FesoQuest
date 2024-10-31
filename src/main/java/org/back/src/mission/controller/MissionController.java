package org.back.src.mission.controller;

import org.back.src.mission.dto.MissionRequestDto;
import org.back.src.mission.dto.MissionResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.mission.entity.Mission;
import org.back.src.mission.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissionController {

    @Autowired
    private MissionService missionService;

    @GetMapping
    public List<MissionResponseDto> getAll() {
        return missionService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissionResponseDto> getById(@PathVariable("id") int id) throws CustomException {
        return ResponseEntity.ok(missionService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Mission> create(@RequestBody MissionRequestDto missao) {
        return new ResponseEntity<>(missionService.create(missao), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mission> update(@PathVariable("id") int id,
                                          @RequestBody MissionRequestDto updatedMissao) throws CustomException {
        return ResponseEntity.ok(missionService.update(id, updatedMissao));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) throws CustomException {
        missionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}