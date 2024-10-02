package org.back.domain.missoes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.back.domain.mesa.Mesa;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "missao")
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "missao_mesa",
        joinColumns = @JoinColumn(
            name = "missao_id",
            foreignKey = @ForeignKey(name = "fk_missao_mesa")
        ),
        inverseJoinColumns = @JoinColumn(
            name = "mesa_id",
            foreignKey = @ForeignKey(name = "fk_missao_mesa_mesa")
        )
    )
    @JsonIgnoreProperties("missoes")
    private List<Mesa> mesas;

    @OneToMany(mappedBy = "missao")
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
