package org.back.domain;

public class Resultado {

    private int id;
    private Questao questao;
    private Alternativa alternativaCorreta;
    private String mensagem;

    public Resultado() {}

    public Resultado(int id, Questao questao, Alternativa alternativaCorreta, String mensagem) {
        this.id = id;
        this.questao = questao;
        this.alternativaCorreta = alternativaCorreta;
        this.mensagem = mensagem;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Alternativa getAlternativaCorreta() {
        return alternativaCorreta;
    }

    public void setAlternativaCorreta(Alternativa alternativaCorreta) {
        this.alternativaCorreta = alternativaCorreta;
    }
}
