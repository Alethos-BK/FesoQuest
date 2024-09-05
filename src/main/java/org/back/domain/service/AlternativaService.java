package org.back.domain.service;

import org.back.domain.missoes.Alternativa;
import org.back.domain.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    public List<Alternativa> getAllAlternativas() {
        return alternativaRepository.findAll();
    }

    public Optional<Alternativa> getAlternativaById(int id) {
        return alternativaRepository.findById(id);
    }

    public Alternativa createAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    public Alternativa updateAlternativa(int id, Alternativa updatedAlternativa) {
        if (!alternativaRepository.existsById(id)) {
            return null;
        }

        updatedAlternativa.setId(id);
        return alternativaRepository.save(updatedAlternativa);
    }

    public boolean deleteAlternativa(int id) {
        if (!alternativaRepository.existsById(id)) {
            return false;
        }

        alternativaRepository.deleteById(id);
        return true;
    }

}
