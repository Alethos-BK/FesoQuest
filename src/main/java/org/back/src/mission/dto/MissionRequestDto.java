package org.back.src.mission.dto;

import org.back.src.party.entity.Party;
import org.back.src.question.entity.Question;

import java.time.LocalDate;
import java.util.List;

public class MissionRequestDto {

    private int id;
    private List<Party> parties;
    private List<Question> questions;
    private LocalDate submissionDate;

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public List<Question> getQuestions() { return questions; }

    public void setQuestions(List<Question> questions) { this.questions = questions; }

    public List<Party> getParties() { return parties; }

    public void setParties(List<Party> parties) { this.parties = parties; }

    public LocalDate getSubmissionDate() { return submissionDate; }

    public void setSubmissionDate(LocalDate submissionDate) { this.submissionDate = submissionDate; }

}
