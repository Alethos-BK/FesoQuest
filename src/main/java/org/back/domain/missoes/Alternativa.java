package org.back.domain.missoes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties("alternativas")
@Entity(name = "alternativa")
public class Alternativa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String titulo;


    @ManyToOne
    @JoinColumn(
        name = "questao_id",
        foreignKey = @ForeignKey(name = "fk_alternativa_questao")
    )
    @JsonIgnoreProperties("alternativas")
    private Questao questao;

    public Alternativa() {}

    public Alternativa(int id, String titulo, Questao questao) {
        this.id = id;
        this.titulo = titulo;
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

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

}
