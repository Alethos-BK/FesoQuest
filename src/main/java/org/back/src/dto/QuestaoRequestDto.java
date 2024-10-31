package org.back.src.dto;

import org.back.src.entity.missoes.Alternativa;
import org.back.src.entity.missoes.Missao;
import org.back.src.entity.missoes.Resultado;

import java.time.LocalDate;
import java.util.List;

public class QuestaoRequestDto {

    private int id;
    private String titulo;
    private String descricao;
    private List<Alternativa> alternativas;
    private Missao missao;
    private Resultado resultado;
    private LocalDate entrega;
    private double pontuacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }

    public LocalDate getEntrega() { return entrega; }

    public void setEntrega(LocalDate entrega) { this.entrega = entrega; }

}
