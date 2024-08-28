package org.back.domain;

import java.util.List;

public class Questao {

    private int id;
    private String titulo;
    private String descricao;
    private List<Alternativa> alternativas;

    public Questao() {}

    public Questao(int id, String titulo, List<Alternativa> alternativas, String descricao) {
        this.id = id;
        this.titulo = titulo;
        this.alternativas = alternativas;
        this.descricao = descricao;
    }

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

    public void addAlternativa(Alternativa alternativa) {
        if (alternativas.contains(alternativa)) return;
        alternativas.add(alternativa);
    }

    public void removeAlternativa(Alternativa alternativa) {
        if (!alternativas.contains(alternativa)) return;
        alternativas.add(alternativa);
    }

    public boolean concluir(Alternativa alternativa) {
        Alternativa alternativaEncontrada = alternativas.stream().filter(alternativa::equals).findFirst().get();
        return alternativaEncontrada.isCorreta();
    }
}
