package org.back.domain.missoes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.back.domain.mesa.Mesa;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String titulo;
    private String descricao;

    @OneToMany(mappedBy = "questao")
    @JsonIgnoreProperties(value = {"questoes", "questao"})
    private List<Alternativa> alternativas;

    @ManyToOne
    @JoinColumn(
        name = "missao_id",
        foreignKey = @ForeignKey(name = "fk_questao_missao"))
    private Missao missao;

    @OneToOne(mappedBy = "questao")
    private Resultado resultado;

    private LocalDate entrega;
    private double pontuacao;

    public Questao() {}

    public Questao(int id, String titulo, List<Alternativa> alternativas, String descricao, LocalDate entrega) {
        this.id = id;
        this.titulo = titulo;
        this.alternativas = alternativas;
        this.descricao = descricao;
        this.entrega = entrega;
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

    public LocalDate getEntrega() { return entrega; }

    public void setEntrega(LocalDate entrega) { this.entrega = entrega; }
}
