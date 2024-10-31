package org.back.src.service;

import org.back.src.conversor.MapperConvert;
import org.back.src.dto.MesaRequestDto;
import org.back.src.dto.MesaResponseDto;
import org.back.src.dto.QuestaoRequestDto;
import org.back.src.dto.QuestaoResponseDto;
import org.back.src.entity.missoes.Missao;
import org.back.src.entity.missoes.Questao;
import org.back.src.exception.CustomException;
import org.back.src.entity.mesa.Mesa;
import org.back.src.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<MesaResponseDto> getAll() {
        List<Mesa> mesas = mesaRepository.findAll();

        return mesas.stream().map(mesa ->
                MapperConvert.convert(mesa, MesaResponseDto.class)).toList();
    }

    public MesaResponseDto getById(int id) throws CustomException {
        Mesa mesa = mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada"));

        return MapperConvert.convert(mesa, MesaResponseDto.class);
    }

    public Mesa create(MesaRequestDto mesaRequestDto) throws CustomException {
        Mesa mesa = MapperConvert.convert(mesaRequestDto, Mesa.class);
        return mesaRepository.save(mesa);
    }

    public Mesa update(int id, MesaRequestDto mesaRequestDto) throws CustomException {
        mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        Mesa mesa = MapperConvert.convert(mesaRequestDto, Mesa.class);
        mesa.setId(id);

        return mesaRepository.save(mesa);
    }

    public void delete(int id) throws CustomException {
        mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        mesaRepository.deleteById(id);
    }

}
