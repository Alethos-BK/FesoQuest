package org.back.src.question.dto;

import org.back.src.question.entity.Choice;
import org.back.src.mission.entity.Mission;
import org.back.src.question.entity.Result;

import java.time.LocalDate;
import java.util.List;

public class QuestionResponseDto {

    private int id;
    private String title;
    private String description;
    private List<Choice> choices;
    private Mission mission;
    private Result result;
    private LocalDate submissionDate;
    private double score;

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

    public LocalDate getSubmissionDate() { return submissionDate; }

    public void setSubmissionDate(LocalDate submissionDate) { this.submissionDate = submissionDate; }

}
