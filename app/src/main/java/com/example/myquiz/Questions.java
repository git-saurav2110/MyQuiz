package com.example.myquiz;

public class Questions {
    private int answerResId;
    private Boolean answertrue;

    public Questions(int answerResId, Boolean answertrue) {
        this.answerResId = answerResId;
        this.answertrue = answertrue;
    }

    public int getAnswerResId() {
        return answerResId;
    }

    public void setAnswerResId(int answerResId) {
        this.answerResId = answerResId;
    }

    public Boolean getAnswertrue() {
        return answertrue;
    }

    public void setAnswertrue(Boolean answertrue) {
        this.answertrue = answertrue;
    }
}
