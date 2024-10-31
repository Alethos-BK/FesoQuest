package org.back.src.question.service;

import org.back.src.shared.conversor.MapperConvert;
import org.back.src.question.dto.QuestionRequestDto;
import org.back.src.question.dto.QuestionResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.question.entity.Question;
import org.back.src.question.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<QuestionResponseDto> getAll() {
        List<Question> questoes = questionRepository.findAll();

        return questoes.stream().map(question ->
                MapperConvert.convert(question, QuestionResponseDto.class)).toList();
    }

    public QuestionResponseDto getById(int id) throws CustomException {
        Question question = questionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        return MapperConvert.convert(question, QuestionResponseDto.class);
    }

    public Question create(QuestionRequestDto questionRequestDto) throws CustomException {
      //  String questaoTransformada = iaService.transformarQuestao(questionRequestDto.getDescricao());
        Question question = MapperConvert.convert("", Question.class);
        return questionRepository.save(question);
    }

    public Question update(int id, QuestionRequestDto questionRequestDto) throws CustomException {
        questionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        Question question = MapperConvert.convert(questionRequestDto, Question.class);
        question.setId(id);

        return questionRepository.save(question);
    }

    public void delete(int id) throws CustomException {
        questionRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        questionRepository.deleteById(id);
    }

}
