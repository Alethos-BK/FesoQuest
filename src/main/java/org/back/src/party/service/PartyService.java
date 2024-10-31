package org.back.src.party.service;

import org.back.src.shared.conversor.MapperConvert;
import org.back.src.party.dto.PartyRequestDto;
import org.back.src.party.dto.PartyResponseDto;
import org.back.src.shared.exception.CustomException;
import org.back.src.party.entity.Party;
import org.back.src.party.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartyService {

    @Autowired
    private PartyRepository partyRepository;

    public List<PartyResponseDto> getAll() {
        List<Party> parties = partyRepository.findAll();

        return parties.stream().map(party ->
                MapperConvert.convert(party, PartyResponseDto.class)).toList();
    }

    public PartyResponseDto getById(int id) throws CustomException {
        Party party = partyRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada"));

        return MapperConvert.convert(party, PartyResponseDto.class);
    }

    public Party create(PartyRequestDto partyRequestDto) throws CustomException {
        Party party = MapperConvert.convert(partyRequestDto, Party.class);
        return partyRepository.save(party);
    }

    public Party update(int id, PartyRequestDto partyRequestDto) throws CustomException {
        partyRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        Party party = MapperConvert.convert(partyRequestDto, Party.class);
        party.setId(id);

        return partyRepository.save(party);
    }

    public void delete(int id) throws CustomException {
        partyRepository.findById(id)
                .orElseThrow(() -> new CustomException(HttpStatus.NOT_FOUND, "Mesa não encontrada!"));

        partyRepository.deleteById(id);
    }

}
