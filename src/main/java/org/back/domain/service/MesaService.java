package org.back.domain.service;

import org.back.domain.mesa.Mesa;
import org.back.domain.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Optional<Mesa> getMesaById(int id) {
        return mesaRepository.findById(id);
    }

    public Mesa createMesa(Mesa mesa) {
        return mesaRepository.save(mesa);
    }

    public Mesa updateMesa(int id, Mesa updatedMesa) {
        if (!mesaRepository.existsById(id)) {
            return null;
        }

        updatedMesa.setId(id);
        return mesaRepository.save(updatedMesa);
    }

    public boolean deleteMesa(int id) {
        if (!mesaRepository.existsById(id)) {
            return false;
        }

        mesaRepository.deleteById(id);
        return true;
    }

}
