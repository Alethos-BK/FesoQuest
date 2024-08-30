package org.back.domain.mesa;

import jakarta.persistence.*;
import org.back.domain.missoes.Missao;
import org.back.domain.usuario.Jogador;
import org.back.domain.usuario.Mestre;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToMany(mappedBy = "mesas")
    private List<Jogador> jogadores;

    @ManyToOne
    @JoinColumn(name = "mestre_id")
    private Mestre mestre;

    @ManyToMany(mappedBy = "mesas")
    private List<Missao> missoes = new ArrayList<>();

    public Mesa(int id, List<Jogador> jogadores, Mestre mestre, List<Missao> missoes) {
        this.id = id;
        this.jogadores = jogadores;
        this.mestre = mestre;
        this.missoes.addAll(missoes);
    }

    public List<Missao> getMissoes() { return missoes; }

    public void setMissoes(List<Missao> missoes) { this.missoes.addAll(missoes); }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Jogador> getJogadores() { return jogadores; }

    public void setJogadores(List<Jogador> jogadores) { this.jogadores = jogadores; }

    public Mestre getMestre() { return mestre; }

    public void setMestre(Mestre mestre) { this.mestre = mestre; }
}
