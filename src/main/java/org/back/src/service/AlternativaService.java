package org.back.src.service;

import org.back.src.exception.CustomException;
import org.back.src.entity.missoes.Alternativa;
import org.back.src.repository.AlternativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlternativaService {

    @Autowired
    private AlternativaRepository alternativaRepository;

    public List<Alternativa> getAll() {
        return alternativaRepository.findAll();
    }

    public Alternativa getById(int id) throws CustomException {
        return alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));
    }

    public Alternativa create(Alternativa alternativa) {
        return alternativaRepository.save(alternativa);
    }

    public Alternativa update(int id, Alternativa updatedAlternativa) throws CustomException {
        alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        updatedAlternativa.setId(id);
        return alternativaRepository.save(updatedAlternativa);
    }

    public void delete(int id) throws CustomException {
        alternativaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Alternativa não encontrada"));

        alternativaRepository.deleteById(id);
    }

}
