package com.senla.bolkunets.virtualtestlab.controllers.dto.methodics.description;

import java.util.List;

public class MethodicsKeyDto {

    private Integer id;

    private String nameScale;

    private List<Integer> numbersQuestions;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameScale() {
        return nameScale;
    }

    public void setNameScale(String nameScale) {
        this.nameScale = nameScale;
    }

    public List<Integer> getNumbersQuestions() {
        return numbersQuestions;
    }

    public void setNumbersQuestions(List<Integer> numbersQuestions) {
        this.numbersQuestions = numbersQuestions;
    }
}
