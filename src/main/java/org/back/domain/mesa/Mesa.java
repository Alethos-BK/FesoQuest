package org.back.domain.mesa;

import jakarta.persistence.*;
import org.back.domain.missoes.Missao;
import org.back.domain.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "jogador_mesa",
        joinColumns = @JoinColumn(
            name = "mesa_id",
            foreignKey = @ForeignKey(name = "fk_jogador_mesa_mesa")
        ),
        inverseJoinColumns = @JoinColumn(
            name = "jogador_id",
            foreignKey = @ForeignKey(name = "fk_jogador_mesa_jogador")
        )
    )
    private List<Usuario> jogadores;

    @ManyToOne
    @JoinColumn(
        name = "mestre_id",
        foreignKey = @ForeignKey(name = "fk_mesa_mestre")
    )
    private Usuario mestre;

    @ManyToMany(mappedBy = "mesas")
    private final List<Missao> missoes = new ArrayList<>();

    public Mesa(int id, List<Usuario> jogadores, Usuario mestre, List<Missao> missoes) {
        this.id = id;
        this.jogadores = jogadores;
        this.mestre = mestre;
        this.missoes.addAll(missoes);
    }

    public Mesa() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Missao> getMissoes() { return missoes; }

    public void setMissoes(List<Missao> missoes) { this.missoes.addAll(missoes); }

    public List<Usuario> getJogadores() { return jogadores; }

    public void setJogadores(List<Usuario> jogadores) { this.jogadores = jogadores; }

    public Usuario getMestre() { return mestre; }

    public void setMestre(Usuario mestre) { this.mestre = mestre; }
}
