package org.back.src.question.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@JsonIgnoreProperties("choices")
@Entity(name = "choice")
public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(
        name = "question_id",
        foreignKey = @ForeignKey(name = "fk_choice_question")
    )
    @JsonIgnoreProperties("choices")
    private Question question;

    public Choice() {}

    public Choice(int id, String title, Question question) {
        this.id = id;
        this.title = title;
        this.question = question;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

}
