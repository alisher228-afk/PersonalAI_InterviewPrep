package org.akusher.personalai_interviewprep.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @JoinColumn(name = "topic_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;
    @NotNull
    private String text;
    @Enumerated(EnumType.STRING)
    private Difficult difficulty;
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();
    public Question() {}
    public Question(Long id, Topic topic, String text, Difficult difficulty) {
        this.id = id;
        this.topic = topic;
        this.text = text;
        this.difficulty = difficulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public Difficult getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficult difficulty) {
        this.difficulty = difficulty;
    }
}
