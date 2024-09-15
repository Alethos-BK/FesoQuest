package org.back.domain.service;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Missao;
import org.back.domain.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissaoService {

    @Autowired
    private MissaoRepository missaoRepository;

    public List<Missao> getAllMissoes() {
        return missaoRepository.findAll();
    }

    public Missao getMissaoById(int id) throws CustomException {
        return missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));
    }

    public Missao createMissao(Missao missao) {
        return missaoRepository.save(missao);
    }

    public Missao updateMissao(int id, Missao updatedMissao) throws CustomException {
        missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        updatedMissao.setId(id);
        return missaoRepository.save(updatedMissao);
    }

    public void deleteMissao(int id) throws CustomException {
        missaoRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Missão não encontrada!"));

        missaoRepository.deleteById(id);
    }
}