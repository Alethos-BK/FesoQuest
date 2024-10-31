package org.back.src.mission.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.back.src.party.entity.Party;
import org.back.src.question.entity.Question;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @ManyToMany
    @JoinTable(
        name = "mission_party",
        joinColumns = @JoinColumn(
            name = "mission_id",
            foreignKey = @ForeignKey(name = "fk_mission_party")
        ),
        inverseJoinColumns = @JoinColumn(
            name = "party_id",
            foreignKey = @ForeignKey(name = "fk_mission_party_party")
        )
    )
    @JsonIgnoreProperties("missions")
    private List<Party> parties;

    @OneToMany(mappedBy = "mission")
    private List<Question> questions;

    private LocalDate submissionDate;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Question> getQuestions() { return questions; }

    public void setQuestoes(List<Question> questions) { this.questions = questions; }

    public List<Party> getParties() { return parties; }

    public void setParties(List<Party> parties) { this.parties = parties; }

    public LocalDate getSubmissionDate() { return submissionDate; }

    public void setSubmissionDate(LocalDate submissionDate) { this.submissionDate = submissionDate; }
}
