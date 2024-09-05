package org.back.domain.service;

import org.back.domain.missoes.Missao;
import org.back.domain.repository.MissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Missao> getMissaoById(int id) {
        return missaoRepository.findById(id);
    }

    public Missao createMissao(Missao missao) {
        return missaoRepository.save(missao);
    }

    public Missao updateMissao(int id, Missao updatedMissao) {
        if (!missaoRepository.existsById(id)) {
            return null;
        }

        updatedMissao.setId(id);
        return missaoRepository.save(updatedMissao);
    }

    public boolean deleteMissao(int id) {
        if (!missaoRepository.existsById(id)) {
            return false;
        }

        missaoRepository.deleteById(id);
        return true;
    }
}