package com.mosdev.restapi.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class QuizQuest {

    public QuizQuest() {
    }

    public QuizQuest(Integer quiz_id, String quest_text, Set<QuizAnswer> answers) {
        this.quiz_id = quiz_id;
        this.quest_text = quest_text;
        this.answers = answers;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer quiz_id;
    private String quest_text;

    @OneToMany(mappedBy = "quest_id")
    private Set<QuizAnswer> answers;

    public Set<QuizAnswer> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<QuizAnswer> answers) {
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getQuest_text() {
        return quest_text;
    }

    public void setQuest_text(String quest_text) {
        this.quest_text = quest_text;
    }
}
