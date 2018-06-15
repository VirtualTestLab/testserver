package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

public class AnswerQuestionDto {

    private Integer questionNumber;
    private Integer value;

    public Integer getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(Integer questionNumber) {
        this.questionNumber = questionNumber;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
