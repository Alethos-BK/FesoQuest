package org.back.domain.service;

import org.back.domain.exception.CustomException;
import org.back.domain.missoes.Alternativa;
import org.back.domain.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    public Alternativa getAlternativaById(int id) throws CustomException {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));
    }

    public Alternativa createAlternativa(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    public Alternativa updateAlternativa(int id, Alternativa updatedAlternativa) throws CustomException {
        alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        updatedAlternativa.setId(id);
        return alternativaRepository.save(updatedAlternativa);
    }

    public void deleteAlternativa(int id) throws CustomException {
        alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        alternativaRepository.deleteById(id);
    }

}
