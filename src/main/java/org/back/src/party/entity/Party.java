package org.back.src.party.entity;

import jakarta.persistence.*;
import org.back.src.mission.entity.Mission;
import org.back.src.user.entity.User;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "party")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "player_party",
        joinColumns = @JoinColumn(
            name = "party_id",
            foreignKey = @ForeignKey(name = "fk_player_party_party")
        ),
        inverseJoinColumns = @JoinColumn(
            name = "player_id",
            foreignKey = @ForeignKey(name = "fk_player_party_player")
        )
    )
    private List<User> players;

    @ManyToOne
    @JoinColumn(
        name = "game_master_id",
        foreignKey = @ForeignKey(name = "fk_party_game_master")
    )
    private User gameMaster;

    @ManyToMany(mappedBy = "parties")
    private final List<Mission> missions = new ArrayList<>();

    public Party(int id, List<User> players, User gameMaster, List<Mission> missions) {
        this.id = id;
        this.players = players;
        this.gameMaster = gameMaster;
        this.missions.addAll(missions);
    }

    public Party() {}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Mission> getMissions() { return missions; }

    public void setMissions(List<Mission> missions) { this.missions.addAll(missions); }

    public List<User> getPlayers() { return players; }

    public void setPlayers(List<User> players) { this.players = players; }

    public User getGameMaster() { return gameMaster; }

    public void setGameMaster(User gameMaster) { this.gameMaster = gameMaster; }
}
