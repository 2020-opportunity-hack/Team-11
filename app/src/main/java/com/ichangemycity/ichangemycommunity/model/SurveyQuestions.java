package com.ichangemycity.ichangemycommunity.model;

import java.util.ArrayList;

//TODO: Modify accordingly. Survey questions model coming from backend
public class SurveyQuestions {

    private String question;
    private ArrayList<String> options;

    public SurveyQuestions(String question, ArrayList<String> options) {
        this.question = question;
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
