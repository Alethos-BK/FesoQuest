package org.back.src.party.dto;

import org.back.src.mission.entity.Mission;
import org.back.src.user.entity.User;

import java.util.ArrayList;
import java.util.List;

public class PartyRequestDto {

    private int id;
    private List<User> jogadores;
    private User mestre;
    private final List<Mission> missoes = new ArrayList<>();

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Mission> getMissoes() { return missoes; }

    public void setMissoes(List<Mission> missoes) { this.missoes.addAll(missoes); }

    public List<User> getJogadores() { return jogadores; }

    public void setJogadores(List<User> jogadores) { this.jogadores = jogadores; }

    public User getMestre() { return mestre; }

    public void setMestre(User mestre) { this.mestre = mestre; }

}
