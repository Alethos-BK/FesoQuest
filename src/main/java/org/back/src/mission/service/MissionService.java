package org.back.src.mission.service;

import org.back.src.shared.conversor.MapperConvert;
import org.back.src.mission.dto.MissionRequestDto;
import org.back.src.mission.dto.MissionResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.mission.entity.Mission;
import org.back.src.mission.repository.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    @Autowired
    private MissionRepository missionRepository;

    public List<MissionResponseDto> getAll() {
        List<Mission> missions = missionRepository.findAll();

        return missions.stream().map(mission ->
                MapperConvert.convert(mission, MissionResponseDto.class)).toList();
    }

    public MissionResponseDto getById(int id) throws CustomException {
        Mission mission = missionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        return MapperConvert.convert(mission, MissionResponseDto.class);
    }

    public Mission create(MissionRequestDto missionRequestDto) {
        Mission mission = MapperConvert.convert(missionRequestDto, Mission.class);
        return missionRepository.save(mission);
    }

    public Mission update(int id, MissionRequestDto missionRequestDto) throws CustomException {
        missionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        Mission mission = MapperConvert.convert(missionRequestDto, Mission.class);
        mission.setId(id);

        return missionRepository.save(mission);
    }

    public void delete(int id) throws CustomException {
        missionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        missionRepository.deleteById(id);
    }
}