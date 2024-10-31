package org.back.src.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.back.src.mission.entity.Mission;

import java.time.LocalDate;
import java.util.List;


@Entity(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String title;

    private String description;

    @OneToMany(mappedBy = "question")
    @JsonIgnoreProperties(value = {"questions", "question"})
    private List<Choice> choices;

    @ManyToOne
    @JoinColumn(
        name = "mission_id",
        foreignKey = @ForeignKey(name = "fk_question_mission"))
    private Mission mission;

    @OneToOne(mappedBy = "question")
    private Result result;

    private LocalDate submissionDate;

    private double score;

    public Question() {}

    public Question(int id, String title, List<Choice> choices, String description, LocalDate submissionDate) {
        this.id = id;
        this.title = title;
        this.choices = choices;
        this.description = description;
        this.submissionDate = submissionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void addChoices(Choice choice) {
        if (choices.contains(choice)) return;
        choices.add(choice);
    }

    public void removeChoice(Choice choice) {
        if (!choices.contains(choice)) return;
        choices.add(choice);
    }

    public LocalDate getSubmissionDate() { return submissionDate; }

    public void setSubmissionDate(LocalDate submissionDate) { this.submissionDate = submissionDate; }
}
