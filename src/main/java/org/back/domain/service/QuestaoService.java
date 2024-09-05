package org.back.domain.service;

import org.back.domain.missoes.Questao;
import org.back.domain.repository.QuestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestaoService {

    @Autowired
    private QuestaoRepository questaoRepository;

    public List<Questao> getAllQuestoes() {
        return questaoRepository.findAll();
    }

    public Optional<Questao> getQuestaoById(int id) {
        return questaoRepository.findById(id);
    }

    public Questao createQuestao(Questao questao) {
        return questaoRepository.save(questao);
    }

    public Questao updateQuestao(int id, Questao updatedQuestao) {
        if (!questaoRepository.existsById(id)) {
            return null;
        }

        updatedQuestao.setId(id);
        return questaoRepository.save(updatedQuestao);
    }

    public boolean deleteQuestao(int id) {
        if (!questaoRepository.existsById(id)) {
            return false;
        }

        questaoRepository.deleteById(id);
        return true;
    }

}
