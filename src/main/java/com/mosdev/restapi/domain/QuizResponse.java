package com.mosdev.restapi.domain;

import java.util.ArrayList;

public class QuizResponse {

    public QuizResponse() {
    }

    public QuizResponse(Integer quiz_id, Integer user_id, ArrayList<Integer> answers) {
        this.quiz_id = quiz_id;
        this.user_id = user_id;
        this.answers = answers;
    }

    private Integer quiz_id,user_id;

    private ArrayList<Integer> answers;

    public Integer getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(Integer quiz_id) {
        this.quiz_id = quiz_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public ArrayList<Integer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Integer> answers) {
        this.answers = answers;
    }
}
