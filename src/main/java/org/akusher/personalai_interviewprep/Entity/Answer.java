package org.akusher.personalai_interviewprep.Entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "question_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;
    private String answer_text;
    private double ai_score;
    private String ai_feedback;
    private LocalDateTime created_at;

    public Answer() {}
    public Answer(int id, Question question, String answer_text, double ai_score, String ai_feedback, LocalDateTime created_at) {
        this.id = id;
        this.question = question;
        this.answer_text = answer_text;
        this.ai_score = ai_score;
        this.ai_feedback = ai_feedback;
        this.created_at = created_at;
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

    public String getAnswer_text() {
        return answer_text;
    }

    public void setAnswer_text(String answer_text) {
        this.answer_text = answer_text;
    }

    public double getAi_score() {
        return ai_score;
    }

    public void setAi_score(double ai_score) {
        this.ai_score = ai_score;
    }

    public String getAi_feedback() {
        return ai_feedback;
    }

    public void setAi_feedback(String ai_feedback) {
        this.ai_feedback = ai_feedback;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }
}
