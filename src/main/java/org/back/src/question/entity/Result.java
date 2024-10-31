package org.back.src.question.entity;

import jakarta.persistence.*;

@Entity(name = "result")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne
    @JoinColumn(
        name = "question_id",
        foreignKey = @ForeignKey(name = "fk_result_question")
    )
    private Question question;

    private String message;

    public Result() {}

    public Result(int id, Question question, Choice correctChoice, String message) {
        this.id = id;
        this.question = question;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
