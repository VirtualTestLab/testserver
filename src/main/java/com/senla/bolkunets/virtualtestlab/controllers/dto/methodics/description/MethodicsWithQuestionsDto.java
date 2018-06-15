package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description;

import java.util.List;

public class MethodicsWithQuestionsDto extends MethodicsDescriptionDto {

    private List<QuestionsDto> questions;

    public List<QuestionsDto> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionsDto> questions) {
        this.questions = questions;
    }
}
