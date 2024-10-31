package org.back.src.service;

import org.back.src.conversor.MapperConvert;
import org.back.src.dto.MissaoRequestDto;
import org.back.src.dto.MissaoResponseDto;
import org.back.src.exception.CustomException;
import org.back.src.entity.missoes.Missao;
import org.back.src.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    public List<MissaoResponseDto> getAll() {
        List<Missao> missoes = missaoRepository.findAll();

        return missoes.stream().map(missao ->
                MapperConvert.convert(missao, MissaoResponseDto.class)).toList();
    }

    public MissaoResponseDto getById(int id) throws CustomException {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        return MapperConvert.convert(missao, MissaoResponseDto.class);
    }

    public Missao create(MissaoRequestDto missaoRequestDto) {
        Missao missao = MapperConvert.convert(missaoRequestDto, Missao.class);
        return missaoRepository.save(missao);
    }

    public Missao update(int id, MissaoRequestDto missaoRequestDto) throws CustomException {
        missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        Missao missao = MapperConvert.convert(missaoRequestDto, Missao.class);
        missao.setId(id);

        return missaoRepository.save(missao);
    }

    public void delete(int id) throws CustomException {
        missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        missaoRepository.deleteById(id);
    }
}