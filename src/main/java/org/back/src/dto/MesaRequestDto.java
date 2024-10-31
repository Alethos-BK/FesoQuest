package org.back.src.dto;

import org.back.src.entity.missoes.Missao;
import org.back.src.entity.usuario.Usuario;

import java.util.ArrayList;
import java.util.List;

public class MesaRequestDto {

    private int id;
    private List<Usuario> jogadores;
    private Usuario mestre;
    private final List<Missao> missoes = new ArrayList<>();

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Missao> getMissoes() { return missoes; }

    public void setMissoes(List<Missao> missoes) { this.missoes.addAll(missoes); }

    public List<Usuario> getJogadores() { return jogadores; }

    public void setJogadores(List<Usuario> jogadores) { this.jogadores = jogadores; }

    public Usuario getMestre() { return mestre; }

    public void setMestre(Usuario mestre) { this.mestre = mestre; }

}
