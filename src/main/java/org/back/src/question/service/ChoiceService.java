package org.back.src.question.service;

import org.back.src.shared.conversor.MapperConvert;
import org.back.src.question.dto.ChoiceResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.question.entity.Choice;
import org.back.src.question.repository.ChoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChoiceService {

    @Autowired
    private ChoiceRepository choiceRepository;

    public List<ChoiceResponseDto> getAll() {
        List<Choice> choices = choiceRepository.findAll();

        return choices.stream().map(choice ->
                MapperConvert.convert(choice, ChoiceResponseDto.class)).toList();
    }

    public Choice getById(int id) throws CustomException {
        return choiceRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));
    }

    public Choice create(Choice choice) {
        return choiceRepository.save(choice);
    }

    public Choice update(int id, Choice updatedChoice) throws CustomException {
        choiceRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        updatedChoice.setId(id);
        return choiceRepository.save(updatedChoice);
    }

    public void delete(int id) throws CustomException {
        choiceRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        choiceRepository.deleteById(id);
    }

}
