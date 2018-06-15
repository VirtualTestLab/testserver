package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description;

import java.util.List;

public class FullMethodicsDto extends MethodicsDescriptionDto {

    private List<QuestionsDto> questionsDtos;

    private List<MethodicsKeyDto> methodicsKeyDtoList;

    public List<QuestionsDto> getQuestionsDtos() {
        return questionsDtos;
    }

    public void setQuestionsDtos(List<QuestionsDto> questionsDtos) {
        this.questionsDtos = questionsDtos;
    }

    public List<MethodicsKeyDto> getMethodicsKeyDtoList() {
        return methodicsKeyDtoList;
    }

    public void setMethodicsKeyDtoList(List<MethodicsKeyDto> methodicsKeyDtoList) {
        this.methodicsKeyDtoList = methodicsKeyDtoList;
    }
}
