package org.back.domain.missoes;

import jakarta.persistence.*;

@Entity(name = "resultado")
public class Resultado {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(
        name = "questao_id",
        foreignKey = @ForeignKey(name = "fk_resultado_questao")
    )
    private Questao questao;

    private String mensagem;

    public Resultado() {}

    public Resultado(int id, Questao questao, Alternativa alternativaCorreta, String mensagem) {
        this.id = id;
        this.questao = questao;
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

}
