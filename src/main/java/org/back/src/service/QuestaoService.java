package org.back.src.service;

import org.back.src.conversor.MapperConvert;
import org.back.src.dto.QuestaoRequestDto;
import org.back.src.dto.QuestaoResponseDto;
import org.back.src.dto.UsuarioResponseDto;
import org.back.src.entity.usuario.Usuario;
import org.back.src.exception.CustomException;
import org.back.src.entity.missoes.Questao;
import org.back.src.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    @Autowired
    private IAService iaService;

    public List<QuestaoResponseDto> getAll() {
        List<Questao> questoes = questaoRepository.findAll();

        return questoes.stream().map(questao ->
                MapperConvert.convert(questao, QuestaoResponseDto.class)).toList();
    }

    public QuestaoResponseDto getById(int id) throws CustomException {
        Questao questao = questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        return MapperConvert.convert(questao, QuestaoResponseDto.class);
    }

    public Questao create(QuestaoRequestDto questaoRequestDto) throws CustomException {
        String questaoTransformada = iaService.transformarQuestao(questaoRequestDto.getDescricao());
        Questao questao = MapperConvert.convert(questaoTransformada, Questao.class);
        return questaoRepository.save(questao);
    }

    public Questao update(int id, QuestaoRequestDto questaoRequestDto) throws CustomException {
        questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        Questao questao = MapperConvert.convert(questaoRequestDto, Questao.class);
        questao.setId(id);

        return questaoRepository.save(questao);
    }

    public void delete(int id) throws CustomException {
        questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        questaoRepository.deleteById(id);
    }

}
