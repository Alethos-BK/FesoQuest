package org.back.domain.service;

import org.back.domain.exception.CustomException;
import org.back.domain.mesa.Mesa;
import org.back.domain.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

    @Autowired
    private MesaRepository mesaRepository;

    public List<Mesa> getAllMesas() {
        return mesaRepository.findAll();
    }

    public Mesa getMesaById(int id) throws CustomException {
        return mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(int id, Mesa updatedMesa) throws CustomException {
        mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        updatedMesa.setId(id);
        return mesaRepository.save(updatedMesa);
    }

    public void deleteMesa(int id) throws CustomException {
        mesaRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        mesaRepository.deleteById(id);
    }

}
