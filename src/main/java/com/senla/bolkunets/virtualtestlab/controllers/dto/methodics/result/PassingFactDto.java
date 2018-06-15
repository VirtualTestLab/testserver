package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.result;

import java.util.List;

public class PassingFactDto {

    private Integer id;

    private Integer methodicsId;

    private Integer personId;

    private List<AnswerQuestionDto> answers;

    public Integer getMethodicsId() {
        return methodicsId;
    }

    public void setMethodicsId(Integer methodicsId) {
        this.methodicsId = methodicsId;
    }

    public List<AnswerQuestionDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerQuestionDto> answers) {
        this.answers = answers;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }
}
