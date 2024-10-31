package org.back.src.dto;

import org.back.src.entity.mesa.Mesa;
import org.back.src.entity.missoes.Questao;

import java.time.LocalDate;
import java.util.List;

public class MissaoRequestDto {

    private int id;
    private List<Mesa> mesas;
    private List<Questao> questoes;
    private LocalDate entrega;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Questao> getQuestoes() { return questoes; }

    public void setQuestoes(List<Questao> questoes) { this.questoes = questoes; }

    public List<Mesa> getMesas() { return mesas; }

    public void setMesas(List<Mesa> mesas) { this.mesas = mesas; }

    public LocalDate getEntrega() { return entrega; }

    public void setEntrega(LocalDate entrega) { this.entrega = entrega; }

}
