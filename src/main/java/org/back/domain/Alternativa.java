package org.back.domain;

public class Alternativa {

    private int id;
    private String titulo;
    private boolean isCorreta;
    private Questao questao;

    public Alternativa() {}

    public Alternativa(int id, String titulo, boolean isCorreta, Questao questao) {
        this.id = id;
        this.titulo = titulo;
        this.isCorreta = isCorreta;
        this.questao = questao;
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

    public boolean isCorreta() {
        return isCorreta;
    }

    public void setCorreta(boolean correta) {
        isCorreta = correta;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
}
