package org.back.src.dto;

import org.back.src.entity.missoes.Questao;

public class AlternativaRequestDto {

    private int id;
    private String titulo;
    private Questao questao;

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

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

}
