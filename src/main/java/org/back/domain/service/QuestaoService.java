package org.back.domain.service;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Questao;
import org.back.domain.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public List<Questao> getAllQuestoes() {
        return questaoRepository.findAll();
    }

    public Questao getQuestaoById(int id) throws CustomException {
        return questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));
    }

    public Questao createQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    public Questao updateQuestao(int id, Questao updatedQuestao) throws CustomException {
        questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        updatedQuestao.setId(id);
        return questaoRepository.save(updatedQuestao);
    }

    public void deleteQuestao(int id) throws CustomException {
        questaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Questão não encontrada"));

        questaoRepository.deleteById(id);
    }

}
